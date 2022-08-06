package com.avr.core

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

fun NavGraphBuilder.register(
    baseFeatureApi: BaseFeatureApi,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    baseFeatureApi.registerGraph(
        navGraphBuilder = this,
        navController = navController,
        modifier = modifier
    )
}