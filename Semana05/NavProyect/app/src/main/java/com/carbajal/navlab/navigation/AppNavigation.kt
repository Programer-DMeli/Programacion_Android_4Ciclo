package com.carbajal.navlab.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.carbajal.navlab.screens.*
import androidx.navigation.NavType


@Composable
fun AppNavigation(){

    //Instanciamos la funcion rememberNanController
    val navController = rememberNavController()

    NavHost(

        //Esto es la logica para mostrar la primera pantalla de la App
        navController = navController,
        startDestination = Screen.Home.route  //Ruta por defecto para abrir la app
    ){

        //usamos la funcion composable para registrar cada pantalla en la ruta

        composable(Screen.Home.route){
            HomeScreen(navController)
        }
        //cuando se llama a NavController.navigate(listScreen), el NavController busca listScreen dentro de estas rutas que llevan una logica de NavGrap
        //NavHost se encarga de renderizar la funcion composable ListScreen

        composable(Screen.List.route) {
            ListScreen(navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
        //Rutas con argumento tipado
    }
}