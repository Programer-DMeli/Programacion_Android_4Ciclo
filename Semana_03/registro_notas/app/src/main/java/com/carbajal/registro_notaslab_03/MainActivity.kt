package com.carbajal.registro_notaslab_03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.carbajal.registro_notaslab_03.ui.theme.Registro_notasLab_03Theme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
    var nota1 by remember { mutableFloatStateOf(0f) }
    var nota2 by remember { mutableFloatStateOf(0f) }
    var nota3 by remember { mutableFloatStateOf(0f) }
    var nota4 by remember { mutableFloatStateOf(0f) }

    //variables para los controles switch y checkbox
    var redondear by remember { mutableStateOf(false) }
    var confirmado by remember { mutableStateOf(false) }

    //Para observar el resultado
    var promedioPonderado by remember { mutableDoubleStateOf(0.0) }
    var promedioFinalStr by remember { mutableStateOf("") }
    var observacion by remember { mutableStateOf("") }
    var chipColor by remember { mutableStateOf(Color.Gray) }
    var mostrarResultado by remember { mutableStateOf(false) }
    //implementacion de color para fondo degradado suave

    val purplePrimary = Color(0xFF5E4B8B)
    val purpleLightBackground = Color(0xFFEDE7F6)
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(purplePrimary, purpleLightBackground)
                )
            )
    ) {

        //Encabezado principal
        Box(
            modifier = Modifier.fillMaxWidth().padding(vertical =  16.dp, horizontal = 20.dp))
        {
            Text(text = "Registro de Notas", color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold

            )
        }
    }


}