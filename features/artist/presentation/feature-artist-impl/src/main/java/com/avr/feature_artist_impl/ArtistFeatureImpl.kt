package com.avr.feature_artist_impl

import android.content.Intent
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.avr.feature_artist_api.ArtistFeatureApi

class ArtistFeatureImpl: ArtistFeatureApi {
    private val baseRoute = "artist"

    override fun artistRoute() = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) {
            val context = LocalContext.current
            context.startActivity(Intent(context, ArtistsActivity::class.java))
            //PopularTVShowListScreen(modifier = modifier, navController = navController)
        }
    }
}