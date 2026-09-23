package com.carbajal.navlab.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.carbajal.navlab.ui.screens.DirectoryScreen
import com.carbajal.navlab.ui.screens.DetailScreen
import com.carbajal.navlab.ui.screens.HomeScreen
import com.carbajal.navlab.ui.screens.LoginScreen
import com.carbajal.navlab.ui.screens.ProfileScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginScreen(onLoginClick = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Login.route) { inclusive = true }
                }
            })
        }
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateDirectory = { navController.navigate(Screen.Directory.route) },
                onNavigateProfile = { navController.navigate(Screen.Profile.route) },
                onLogout = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(0)
                    }
                }
            )
        }
        composable(Screen.Directory.route) {
            DirectoryScreen(
                onBack = { navController.popBackStack() },
                onStudentClick = { id -> navController.navigate(Screen.Detail.createRoute(id)) }
            )
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("itemId") ?: 1
            DetailScreen(
                studentId = id,
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.Profile.route) {
            ProfileScreen(
                onBack = { navController.popBackStack() },
                onLogout = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(0)
                    }
                }
            )
        }
    }
}