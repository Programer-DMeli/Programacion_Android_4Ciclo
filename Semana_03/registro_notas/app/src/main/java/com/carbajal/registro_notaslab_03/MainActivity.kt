package com.carbajal.registro_notaslab_03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carbajal.registro_notaslab_03.ui.theme.Registro_notasLab_03Theme
import kotlin.math.roundToInt

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

fun formatDosDecimales(valor: Double): String {
    val redondeado = (valor * 100).roundToInt() / 100.0
    return redondeado.toString()
}
fun obtenerObservacionYColor(promedio: Double): Pair<String, Color> {
    return when {
        promedio >= 17.0 -> "EXCELENTE" to Color(0xFF1B5E20)
        promedio >= 13.0 -> "APROBADO" to Color(0xFF4CAF50)
        promedio >= 10.0 -> "EN RECUPERACIÓN" to Color(0xFFFFB300)
        else -> "DESAPROBADO" to Color(0xFFD32F2F)
    }
}
@Composable
fun visualizacionPantalla(modifier: Modifier = Modifier) {
    var nota1 by remember { mutableFloatStateOf(0f) }
    var nota2 by remember { mutableFloatStateOf(0f) }
    var nota3 by remember { mutableFloatStateOf(0f) }
    var nota4 by remember { mutableFloatStateOf(0f) }

    var redondear by remember { mutableStateOf(false) }
    var confirmado by remember { mutableStateOf(false) }

    var promedioPonderado by remember { mutableDoubleStateOf(0.0) }
    var promedioFinalStr by remember { mutableStateOf("") }
    var observacion by remember { mutableStateOf("") }
    var chipColor by remember { mutableStateOf(Color.Gray) }
    var mostrarResultado by remember { mutableStateOf(false) }

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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 20.dp)
        ) {
            Text(
                text = "Registro de Notas",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Card(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Notas del Ciclo",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "Desliza para asignar cada nota (0 a 20)",
                    fontSize = 12.sp,
                    color = Color.Gray
                )

                // Controles Slider
                CursoItem("Fundamentos de Programación", 20, nota1) { nota1 = it }
                CursoItem("Programación Orientada a Objetos", 25, nota2) { nota2 = it }
                CursoItem("Programación en Móviles", 30, nota3) { nota3 = it }
                CursoItem("Base de Datos", 25, nota4) { nota4 = it }

                Spacer(modifier = Modifier.height(4.dp))

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

                // Botones: CALCULAR y LIMPIAR
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = {
                            val n1 = nota1.toInt()
                            val n2 = nota2.toInt()
                            val n3 = nota3.toInt()
                            val n4 = nota4.toInt()

                            val pond = (n1 * 0.20) + (n2 * 0.25) + (n3 * 0.30) + (n4 * 0.25)
                            promedioPonderado = pond

                            val finalVal: Double = if (redondear) {
                                pond.roundToInt().toDouble()
                            } else {
                                pond
                            }

                            promedioFinalStr = if (redondear) {
                                "${finalVal.toInt()}"
                            } else {
                                formatDosDecimales(finalVal)
                            }

                            val (obsTexto, colorResultado) = obtenerObservacionYColor(finalVal)
                            observacion = obsTexto
                            chipColor = colorResultado

                            mostrarResultado = true
                        },
                        enabled = confirmado,
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = purplePrimary,
                            disabledContainerColor = Color(0xFFBDBDBD)
                        )
                    ) {
                        Text(text = "CALCULAR", fontWeight = FontWeight.Bold)
                    }

                    // Botón LIMPIAR
                    OutlinedButton(
                        onClick = {
                            nota1 = 0f
                            nota2 = 0f
                            nota3 = 0f
                            nota4 = 0f
                            redondear = false
                            confirmado = false
                            mostrarResultado = false
                        },
                        modifier = Modifier.height(48.dp)
                    ) {
                        Text(text = "LIMPIAR", color = Color(0xFFD32F2F), fontWeight = FontWeight.Bold)
                    }
                }

                if (!mostrarResultado) {
                    Text(
                        text = "Asigna las notas y confirma para calcular",
                        fontSize = 13.sp,
                        color = Color.Gray,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                } else {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            //  Aporte por curso con porcentajes
                            Text(text = "Aporte por curso:", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                            Text(text = "• Fundamentos: ${nota1.toInt()} × 20% = ${formatDosDecimales(nota1.toInt() * 0.20)}", fontSize = 12.sp, color = Color.DarkGray)
                            Text(text = "• POO: ${nota2.toInt()} × 25% = ${formatDosDecimales(nota2.toInt() * 0.25)}", fontSize = 12.sp, color = Color.DarkGray)
                            Text(text = "• Móviles: ${nota3.toInt()} × 30% = ${formatDosDecimales(nota3.toInt() * 0.30)}", fontSize = 12.sp, color = Color.DarkGray)
                            Text(text = "• Base de Datos: ${nota4.toInt()} × 25% = ${formatDosDecimales(nota4.toInt() * 0.25)}", fontSize = 12.sp, color = Color.DarkGray)

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = "Promedio ponderado:  ${formatDosDecimales(promedioPonderado)}",
                                fontSize = 14.sp
                            )

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "Promedio final:  $promedioFinalStr",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = purplePrimary
                                )
                            }
                            if (redondear) {
                                Text(
                                    text = "(redondeado)",
                                    fontSize = 12.sp,
                                    color = Color.Gray
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Surface(
                                color = chipColor.copy(alpha = 0.15f),
                                shape = RoundedCornerShape(16.dp)
                            ) {
                                Text(
                                    text = observacion,
                                    color = chipColor,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp,
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                                )
                            }
                        }
                    }

                    Text(
                        text = "✓  Promedio calculado correctamente",
                        color = Color(0xFF2E7D32),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Desarrollado por: Meliton Carbajal",
            fontSize = 11.sp,
            color = Color.Gray,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        )
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
    // Reto 2: Expresión "if" para evaluar el color del semáforo
    val semaforoColor = if (nota.toInt() < 13) Color(0xFFD32F2F) else Color(0xFF2E7D32)

    Column {
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
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF5E4B8B)
                )
            }

            // Badge con semáforo dinámico
            Surface(
                color = semaforoColor.copy(alpha = 0.12f),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    text = nota.toInt().toString(),
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                    color = semaforoColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }
        }
        Slider(
            value = nota,
            onValueChange = onNotaChange,
            valueRange = 0f..20f,
            steps = 19,
            thumb = {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF5E4B8B))
                )
            },
            track = { sliderState ->
                Box(Modifier.height(6.dp)) {
                    SliderDefaults.Track(
                        sliderState = sliderState,
                        thumbTrackGapSize = 0.dp,
                        trackInsideCornerSize = 3.dp,
                        colors = SliderDefaults.colors(
                            activeTrackColor = Color(0xFF5E4B8B),
                            inactiveTrackColor = Color(0xFFC7BBE5),
                            activeTickColor = Color.Transparent,
                            inactiveTickColor = Color.Transparent
                        )
                    )
                }
            },
            colors = SliderDefaults.colors(
                thumbColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 3.dp)
        )
    }
}