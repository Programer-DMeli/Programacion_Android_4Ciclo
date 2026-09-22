package com.carbajal.navlab.navigation

sealed class Screen(val route: String) {
    //Es la ruta a la pantalla de inicio
    object Home : Screen(route = "home")

    //pantalla que muestra la lista de elementos
    object List : Screen(route = "list")

    //Pantalla de perfil de Usuario
    object Profile : Screen(route = "profile")

    // Ruta que requiere un parámetro dinámico itemId
    object Detail : Screen(route = "detail/{itemId}") {
        fun createRoute(itemId: Int): String = "detail/$itemId"
    }
}

