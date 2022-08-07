package com.avr.myfamilyapp.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.avr.dependency_provider.DependencyProvider
import com.avr.myfamilyapp.R

enum class RouteName(val routeName: String) {
    HOME("home"),
    MOVIES("movies"),
    TV("tv"),
    PROFILE("profile")
}

enum class BottomTabs(
    @StringRes
    val title: Int,
    @DrawableRes
    val icon: Int,
    //val homeFeatureApi: HomeFeatureApi,
    val route: String
) {
    HOME(
        R.string.home,
        R.drawable.ic_home,
        DependencyProvider.homeFeature().homeRoute()
    ),
    MOVIES(
        R.string.movie,
        R.drawable.ic_movies,
        //DependencyProvider.movieFeature().movieRoute()
        RouteName.MOVIES.routeName
    ),
    TVSHOWS(
        R.string.tv,
        R.drawable.ic_music,
        DependencyProvider.tvFeature().tvRoute()
    ),
    PROFILE(
        R.string.profile,
        R.drawable.ic_profile,
        RouteName.PROFILE.routeName
    )
}