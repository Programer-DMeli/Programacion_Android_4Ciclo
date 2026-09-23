package com.carbajal.appclinica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.carbajal.appclinica.navigation.AppNavigation
import com.carbajal.appclinica.ui.theme.AppClinicaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppClinicaTheme {
                AppNavigation()
            }
        }
    }
}