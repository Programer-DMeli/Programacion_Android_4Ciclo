package com.carbajal.registro_notaslab_03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.draw.clip
import androidx.compose.material3.Switch
import androidx.compose.material3.Checkbox

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
        //Tarjeta principal de la App
        Card(
            modifier = Modifier
                .fillMaxSize(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFEDE7F6))

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize().padding(16.dp).verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Notas del Ciclo",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black

                )
                Text(
                    text = "Desliza para asignar cada nota (0 a 20)",
                    fontSize = 12.sp, color = Color.Gray
                )
                // Controles Slider por Curso
                CursoItem("Fundamentos de Programación", 20, nota1) { nota1 = it }
                CursoItem("Programación Orientada a Objetos", 25, nota2) { nota2 = it }
                CursoItem("Programación en Móviles", 30, nota3) { nota3 = it }
                CursoItem("Base de Datos", 25, nota4) { nota4 = it }

            }
            // Switch Redondear
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Redondear promedio final", color = Color.DarkGray)
                Switch(
                    checked = redondear,
                    onCheckedChange = { redondear = it }
                )
            }
            // Checkbox Confirmación
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Checkbox(
                        checked = confirmado,
                        onCheckedChange = { confirmado = it }
                    )
                    Text(text = "Confirmo que las notas son correctas", fontSize = 14.sp)
                }
        }
    }


}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CursoItem(
    nombre: String,
    peso: Int,
    nota: Float,
    onNotaChange: (Float) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier.padding(vertical = 10.dp)
    ) {

        // Nombre y porcentaje
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = nombre,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color(0xFF2D2D2D)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "($peso%)",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF8E24AA)
                )
            }

            // Badge de nota
            Surface(
                color = Color(0xFFEDE7F6),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = nota.toInt().toString(),
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                    color = Color(0xFF5E4B8B),
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Slider
        Slider(
            value = nota,
            onValueChange = onNotaChange,
            valueRange = 0f..20f,
            steps = 19,

            // CÍRCULO MORADO PERSONALIZADO
            thumb = {
                Box(
                    modifier = Modifier
                        .size(30.dp)                  // Tamaño del círculo
                        .clip(CircleShape)
                        .background(Color(0xFF5E4B8B))
                )
            },
            // LÍNEA DEL SLIDER
            track = { sliderState ->
                SliderDefaults.Track(
                    sliderState = sliderState,
                    thumbTrackGapSize = 0.dp,
                    trackInsideCornerSize = 3.dp,
                    colors = SliderDefaults.colors(
                        activeTrackColor = Color(0xFFD0BCFF),
                        inactiveTrackColor = Color(0xFFE7E0EC),
                        activeTickColor = Color.Transparent,
                        inactiveTickColor = Color.Transparent
                    )
                )
            },

            colors = SliderDefaults.colors(
                thumbColor = Color.Transparent // Oculta el thumb por defecto
            ),

            modifier = Modifier.fillMaxWidth()
        )
    }
}