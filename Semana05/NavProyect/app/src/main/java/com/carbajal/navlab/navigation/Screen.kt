package com.carbajal.navlab.navigation

//Esta clase actua como un contrato central de Navegacion.
//route es el parametro que funciona como el indentificar unico de cada pantalla.
sealed class Screen(val route: String) {
    //Es la ruta del login
    object Login : Screen("login")

    //Es la ruta a la pantalla de inicio
    object Home : Screen(route = "home")

    //pantalla que muestra la lista de elementos
    object Directory : Screen(route = "directory")

    //Pantalla de perfil de Usuario
    object Profile : Screen(route = "profile")

    // Ruta que requiere un parámetro dinámico itemId
    object Detail : Screen(route = "detail/{itemId}") {
        fun createRoute(itemId: Int): String = "detail/$itemId"
    }
}

