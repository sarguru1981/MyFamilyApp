package com.avr.feature_tv_impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.avr.feature_tv_api.TVFeatureApi
import com.avr.feature_tv_impl.popular.tvlist.PopularTVShowListScreen

class TVFeatureImpl: TVFeatureApi {
    private val baseRoute = "tv"

    override fun tvRoute() = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) {
            PopularTVShowListScreen(modifier = modifier, navController = navController)
        }

        InternalTVFeatureApi.registerGraph(
            navGraphBuilder = navGraphBuilder,
            navController = navController,
            modifier = modifier
        )
    }
}