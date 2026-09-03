package com.carbajal.registro_notaslab_03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.carbajal.registro_notaslab_03.ui.theme.Registro_notasLab_03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Registro_notasLab_03Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    visualizacionPantalla(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun visualizacionPantalla(modifier: Modifier = Modifier){
    //Listas de almacenamiento de las 4 notas


}