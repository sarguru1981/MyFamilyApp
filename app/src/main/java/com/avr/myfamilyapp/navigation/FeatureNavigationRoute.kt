package com.avr.myfamilyapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class FeatureNavigationRoute(
    var route: String,
    val title: String,
    val icon: ImageVector,
) {

    object Home : FeatureNavigationRoute("home", "Home", Icons.Outlined.Home)
    object Posts : FeatureNavigationRoute("posts", "Posts", Icons.Outlined.AddCircle)
    object AboutMe : FeatureNavigationRoute("about_me", "About me", Icons.Outlined.Person)
    object More : FeatureNavigationRoute("more", "More", Icons.Outlined.Menu)

    object Items {
        val list = listOf(
            Home, Posts, AboutMe, More
        )
    }
}
