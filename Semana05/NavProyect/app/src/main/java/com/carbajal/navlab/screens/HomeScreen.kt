package com.carbajal.navlab.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.carbajal.navlab.navigation.Screen

@Composable
fun HomeScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,  //actua en el eje Y de toda la columna
        horizontalAlignment = Alignment.CenterHorizontally  //actua en el eje X
    ) {

        Text(
            text = "Pantalla Tecsup",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                navController.navigate(Screen.List.route)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Ver lista de Elementos")
        }
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedButton(
            onClick = {
                navController.navigate(Screen.Profile.route)},
            modifier = Modifier.fillMaxWidth()

        ) {
            Text(text = "Mi perfil")
        }
    }
}