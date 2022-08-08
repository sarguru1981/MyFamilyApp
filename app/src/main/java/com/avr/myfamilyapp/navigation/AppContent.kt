package com.avr.myfamilyapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.avr.dependency_provider.DependencyProvider
import com.avr.myfamilyapp.R
import com.avr.myfamilyapp.ui.theme.MyFamilyAppTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.navigationBarsPadding
import java.util.*


@Composable
fun AppContent() {
    ProvideWindowInsets {
        MyFamilyAppTheme {
            val tabs = remember { BottomTabs.values() }
            val navController = rememberNavController()
            Scaffold(
                backgroundColor = Color.White,
                bottomBar = { BottomBar(navController = navController, tabs) }
            ) { innerPaddingModifier ->
                AppNavGraph(
                    navController = navController,
                    modifier = Modifier.padding(innerPaddingModifier)
                )
            }
        }
    }
}

@Composable
fun BottomBar(navController: NavController, tabs: Array<BottomTabs>) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: DependencyProvider.homeFeature().homeRoute()

    val routes = remember { BottomTabs.values().map { it.route } }
    if (currentRoute in routes) {
        BottomNavigation(
            Modifier.navigationBarsHeight(additional = 56.dp),
            backgroundColor = colorResource(R.color.bar_color),
            contentColor = colorResource(R.color.black),
        ) {
            tabs.forEach { tab ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = tab.icon),
                            contentDescription = stringResource(tab.title)
                        )
                    },
                    label = { Text(stringResource(tab.title).uppercase(Locale.getDefault())) },
                    selected = currentRoute == tab.route,
                    onClick = {
                        if (tab.route != currentRoute) {
                            navController.navigate(tab.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    alwaysShowLabel = false,
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.White,
                    modifier = Modifier.navigationBarsPadding()
                )
            }
        }
    }
}