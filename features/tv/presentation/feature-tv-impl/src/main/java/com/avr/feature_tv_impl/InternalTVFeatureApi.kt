package com.avr.feature_tv_impl

import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.avr.core.BaseFeatureApi
import com.avr.feature_tv_impl.popular.tvdetail.PopularTVShowDetailScreen

internal object InternalTVFeatureApi: BaseFeatureApi {

    private const val scenarioListToDetailRoute = "scenarioListToDetailRoute"
    private const val parameterKey = "tv_id"

   // private const val DetailRoute = "tv/Detail"

    fun scenarioListToDetailRoute(parameter: String) = "$scenarioListToDetailRoute/${parameter}"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.navigation(
            route = scenarioListToDetailRoute,
            startDestination = "$scenarioListToDetailRoute/{$parameterKey}"
        ) {
            composable(
                route = "$scenarioListToDetailRoute/{$parameterKey}",
                arguments = listOf(navArgument(parameterKey) { type = NavType.StringType })
            ) { backStackEntry ->
                val arguments = requireNotNull(backStackEntry.arguments)
                val argument = arguments.getString(parameterKey)
                PopularTVShowDetailScreen(modifier = modifier, argument = argument.orEmpty(), navController = navController)
            }
        }
    }
}