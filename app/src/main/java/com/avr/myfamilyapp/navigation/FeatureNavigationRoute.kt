package com.avr.myfamilyapp.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.avr.myfamilyapp.R

enum class Route(val routeName: String) {
    HOME("home"),
    MOVIES("movies"),
    TV("tv"),
    PROFILE("profile")
}

sealed class FeatureNavigationRoute(
    var route: String,
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
) {

    object Home : FeatureNavigationRoute(Route.HOME.routeName, R.string.home, R.drawable.ic_home)
    object Movies :
        FeatureNavigationRoute(Route.MOVIES.routeName, R.string.movie, R.drawable.ic_movies)
    object Tv :
        FeatureNavigationRoute(Route.TV.routeName, R.string.tv, R.drawable.ic_music)
    object Profile :
        FeatureNavigationRoute(Route.PROFILE.routeName, R.string.profile, R.drawable.ic_profile)

    object Items {
        val list = listOf(
            Home, Movies, Tv, Profile
        )
    }
}

