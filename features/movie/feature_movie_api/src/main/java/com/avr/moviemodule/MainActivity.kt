package com.avr.moviemodule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.avr.myfamilyapp.ui.theme.MyFamilyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFamilyAppTheme {
               // PostListScreen()
            }
        }
    }
}