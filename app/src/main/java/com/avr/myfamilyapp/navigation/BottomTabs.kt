package com.avr.myfamilyapp.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
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
    val route: String
) {
    HOME(
        R.string.home,
        R.drawable.ic_home,
        RouteName.HOME.routeName
    ),
    MOVIES(
        R.string.movie,
        R.drawable.ic_movies,
        RouteName.MOVIES.routeName
    ),
    TVSHOWS(
        R.string.tv,
        R.drawable.ic_music,
        RouteName.TV.routeName
    ),
    PROFILE(
        R.string.profile,
        R.drawable.ic_profile,
        RouteName.PROFILE.routeName
    )
}