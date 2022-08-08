package com.avr.feature_tv_impl.popular.tvlist


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.avr.domain.entities.tvshowlist.TVShowItem
import com.avr.feature_tv_impl.InternalTVFeatureApi
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle

@Composable
fun PopularTVShowListScreen(
    modifier: Modifier, navController: NavHostController,
    popularTVShowListViewModel: PopularTVShowListViewModel = hiltViewModel()
) {
    val tvShowState by popularTVShowListViewModel.tvShowListState.collectAsState()

    when (tvShowState) {
        is TVShowListState.LoadingState -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
        is TVShowListState.Error -> {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = (tvShowState as TVShowListState.Error).message,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        is TVShowListState.Success -> {
            val tvShowList = (tvShowState as TVShowListState.Success).tvShows

            if (tvShowList != null) {
                AllPopularTVShows(navController, modifier, tvShowList)
            }
        }
    }
}

@Composable
fun AllPopularTVShows(
    navController: NavHostController,
    modifier: Modifier,
    tvShowList: List<TVShowItem>
) {
    Scaffold {
        LazyColumn(
            modifier,
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(vertical = 25.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "\uD83C\uDF3F  Popular TV Shows",
                        style = MaterialTheme.typography.h4
                    )
                }
            }
            items(tvShowList.count()) {
                TVShowCard(it = tvShowList[it]) {
                    navController.navigate(InternalTVFeatureApi.scenarioListToDetailRoute(it))
                    //navController.navigate("postdetail/${it}")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TVShowCard(it: TVShowItem, item: (String) -> Unit) {
    Card(
        modifier = Modifier
            // The space between each card and the other
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = Color(0xFF202124),
        onClick = { item.invoke(it.id.toString()) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = rememberImagePainter(data = "https://image.tmdb.org/t/p/w500" + it.poster_path),
                contentDescription = null,
                modifier = Modifier
                    .size(130.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Fit,
            )
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = it.name,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(),
                    color = Color.White,
                )
                Text(
                    text = it.overview,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(bottom = 4.dp),
                    color = Color.White,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
                Divider()
                var rating = it.vote_average.toFloat()
                RatingBar(
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
            }
        }
    }
}

