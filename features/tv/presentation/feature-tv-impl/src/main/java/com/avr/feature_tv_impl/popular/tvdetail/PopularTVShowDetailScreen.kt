package com.avr.feature_tv_impl.popular.tvdetail

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.avr.domain.entities.tvshowdetail.TVShowDetail
import com.avr.feature_tv_impl.theme.AnimatingFabContent
import com.avr.feature_tv_impl.theme.baselineHeight
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle

@Composable
fun PopularTVShowDetailScreen(
    modifier: Modifier,
    navController: NavHostController,
    argument: String,
    popularTVShowDetailViewModel: PopularTVShowDetailViewModel = hiltViewModel()
) {
    val tvShowDetailState by popularTVShowDetailViewModel.tvShowState.collectAsState()

    when (tvShowDetailState) {
        is TVShowDetailState.LoadingState -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
        is TVShowDetailState.Error -> {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = (tvShowDetailState as TVShowDetailState.Error).message,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        is TVShowDetailState.Success -> {

            (tvShowDetailState as TVShowDetailState.Success).tvShowDetail?.let {
                Column(modifier = Modifier) {
                    DisplayItem(it)
                }
            }
        }
    }
}

@Composable
fun DisplayItem(tvShowDetail: TVShowDetail) {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints(modifier = Modifier.weight(1f)) {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ) {
                    DisplayItemHeader(scrollState, tvShowDetail, this@BoxWithConstraints.maxHeight)
                    DisplayContent(tvShowDetail, this@BoxWithConstraints.maxHeight)
                }
            }
            AdoptMeButton(
                extended = scrollState.value == 0,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }
    }
}

@Composable
fun AdoptMeButton(extended: Boolean, modifier: Modifier) {
    FloatingActionButton(
        onClick = { /* TODO */ },
        modifier = modifier
            .padding(16.dp)
            .padding()
            .height(48.dp)
            .widthIn(min = 48.dp),
        backgroundColor = Color(0xFF3700B3),
        contentColor = Color.White
    ) {
        AnimatingFabContent(
            icon = {
                Icon(
                    imageVector = Icons.Outlined.PlayArrow,
                    contentDescription = "Play"
                )
            },
            text = {
                Text(
                    text = "Watch me",
                )
            },
            extended = extended

        )
    }
}

@Composable
private fun DisplayItemHeader(
    scrollState: ScrollState,
    tvShowDetail: TVShowDetail,
    containerHeight: Dp
) {
    val offset = (scrollState.value / 2)
    val offsetDp = with(LocalDensity.current) { offset.toDp() }

    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth()
            .padding(top = offsetDp),
        painter = rememberImagePainter(data = "https://image.tmdb.org/t/p/w500${tvShowDetail.backdrop_path}"),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
private fun DisplayContent(tvShowDetail: TVShowDetail, containerHeight: Dp) {
    Column {
        Spacer(modifier = Modifier.height(8.dp))

        Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
            Text(
                text = tvShowDetail.name,
                modifier = Modifier.baselineHeight(32.dp),
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold
            )
        }
        DisplayContentProperty("Overview: ", tvShowDetail.overview)
        DisplayContentProperty("Episode time: ", "${tvShowDetail.episode_run_time[0]} mins")

        DisplayContentProperty("Can be viewed in: ", tvShowDetail.homepage)

        DisplayContentProperty(
            "Seasons & Episodes:",
            "${tvShowDetail.number_of_seasons} & ${tvShowDetail.number_of_episodes}"
        )

        DisplayContentProperty("Tags: ", tvShowDetail.tagline)

        var rating = tvShowDetail.vote_average.toFloat()
        RatingBar(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            value = rating,
            config = RatingBarConfig().numStars(10).size(12.dp)
                .style(RatingBarStyle.HighLighted),
            onValueChange = {
                rating = it
            },
            onRatingChanged = {
                Log.d("TAG", "onRatingChanged: $it")
            }
        )

        DisplayContentProperty("Number of votes: ", tvShowDetail.vote_count.toString())
        // Add a spacer that always shows part (320.dp) of the fields list regardless of the device,
        // in order to always leave some content at the top.
        Spacer(Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
fun DisplayContentProperty(label: String, value: String, isLink: Boolean = false) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider()
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = label,
                modifier = Modifier.baselineHeight(24.dp),
                style = MaterialTheme.typography.caption,
            )
        }
        val style = if (isLink) {
            MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.primary)
        } else {
            MaterialTheme.typography.body1
        }
        Text(
            text = value,
            modifier = Modifier.baselineHeight(24.dp),
            style = style
        )
    }
}