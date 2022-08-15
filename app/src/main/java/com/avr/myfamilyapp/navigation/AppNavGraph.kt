package com.avr.myfamilyapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.avr.core.register
import com.avr.dependency_provider.DependencyProvider

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = DependencyProvider.homeFeature().homeRoute()
    ) {
        register(
            DependencyProvider.homeFeature(),
            navController = navController,
            modifier = modifier
        )

       /* register(
            DependencyProvider.movieFeature(),
            navController = navController,
            modifier = modifier
        )*/

        register(
            DependencyProvider.tvFeature(),
            navController = navController,
            modifier = modifier
        )

        register(
            DependencyProvider.artistFeature(),
            navController = navController,
            modifier = modifier
        )
    }
}