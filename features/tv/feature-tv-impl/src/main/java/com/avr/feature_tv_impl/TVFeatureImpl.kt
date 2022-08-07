package com.avr.feature_tv_impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.avr.feature_tv_api.TVFeatureApi

class TVFeatureImpl: TVFeatureApi {
    private val baseRoute = "tv"

    override fun tvRoute() = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) {
            TVScreen(modifier = modifier, navController = navController)
        }
    }
}