package com.avr.moviemodule

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

class MovieFeatureImpl: MovieFeatureApi {
    private val baseRoute = "movie"

    override fun movieRoute() = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) {
            PostListScreen(modifier = modifier, navController = navController)
        }
    }
}