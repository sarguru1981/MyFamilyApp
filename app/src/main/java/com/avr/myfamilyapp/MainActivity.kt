package com.avr.myfamilyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.avr.dependency_provider.DependencyProvider
import com.avr.feature_home_impl.HomeFeatureImpl
import com.avr.myfamilyapp.navigation.AppContent
import com.avr.myfamilyapp.ui.theme.MyFamilyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)

        DependencyProvider.provideImpl(
            homeFeatureApi = HomeFeatureImpl(),
        )

        setContent {
            MyFamilyAppTheme() {
                AppContent()
            }
        }
    }
}


