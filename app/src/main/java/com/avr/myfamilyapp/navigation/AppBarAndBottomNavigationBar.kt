package com.avr.myfamilyapp.navigation

import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.avr.myfamilyapp.BuildConfig
import com.avr.myfamilyapp.R

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController)
            }
        },
        backgroundColor = colorResource(R.color.bar_color) // Set background color to avoid the white flashing when you switch between screens
    )
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = FeatureNavigationRoute.Home.route) {
        composable(FeatureNavigationRoute.Home.route) {
            HomeScreen()
        }
        composable(FeatureNavigationRoute.Movies.route) {
            //MovieScreen()
            val context = LocalContext.current
            context.startActivity(Intent().setClassName(BuildConfig.APPLICATION_ID, "com.avr.moviemodule.MovieActivity"))
        }
        composable(FeatureNavigationRoute.Tv.route) {
            TVScreen()
        }
        composable(FeatureNavigationRoute.Profile.route) {
            ProfileScreen()
        }
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },
        backgroundColor = colorResource(id = R.color.bar_color),
        contentColor = Color.White
    )
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        FeatureNavigationRoute.Home,
        FeatureNavigationRoute.Movies,
        FeatureNavigationRoute.Tv,
        FeatureNavigationRoute.Profile,
    )
    //val background=if (isSelected) MaterialTheme.colors.primary.copy(alpha = 0.1f) else Color.Transparent
    //val contentColor=if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground

    BottomNavigation(
        backgroundColor = Color.Transparent,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = stringResource(item.title))},
                label = { Text(text = stringResource(item.title), fontSize = 9.sp) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White,
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}