package com.example.juego3d

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.math.cos
import kotlin.math.sin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // Contenedor principal con fondo oscuro para resaltar el 3D
                Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF101010)) {
                    Juego3DInteractuando()
                }
            }
        }
    }
}

@Composable
fun Juego3DInteractuando() {
    // ESTADOS: Definimos las variables que cambiarán durante el juego
    var anguloX by remember { mutableStateOf(0f) }
    var anguloY by remember { mutableStateOf(0f) }
    var colorCubo by remember { mutableStateOf(Color.Green) }
    var contadorToques by remember { mutableIntStateOf(0) }

    // BUCLE DE ANIMACIÓN: Actualiza la rotación constantemente (60 FPS aprox)
    LaunchedEffect(Unit) {
        while (true) {
            anguloX += 0.02f
            anguloY += 0.03f
            delay(16)
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text("RA5: Juego 3D Básico", style = MaterialTheme.typography.headlineMedium, color = Color.White)
        Text("Toques: $contadorToques", color = Color.Gray)

        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    // DETECCIÓN TÁCTIL: Al tocar el área del juego
                    detectTapGestures {
                        contadorToques++
                        // Cambio de color aleatorio como regla de negocio
                        colorCubo = Color((0..255).random(), (0..255).random(), (0..255).random())
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.size(300.dp)) {
                val centro = Offset(size.width / 2, size.height / 2)
                val escala = 150f

                // Vértices del cubo en espacio 3D (X, Y, Z)
                val puntos3D = listOf(
                    Triple(-1f, -1f, 1f), Triple(1f, -1f, 1f), Triple(1f, 1f, 1f), Triple(-1f, 1f, 1f),
                    Triple(-1f, -1f, -1f), Triple(1f, -1f, -1f), Triple(1f, 1f, -1f), Triple(-1f, 1f, -1f)
                )

                // PROYECCIÓN: Convertimos 3D a 2D aplicando rotación matemática
                val puntos2D = puntos3D.map { (x, y, z) ->
                    // Rotación en eje Y
                    val xRotY = x * cos(anguloY) - z * sin(anguloY)
                    val zRotY = x * sin(anguloY) + z * cos(anguloY)

                    // Rotación en eje X
                    val yRotX = y * cos(anguloX) - zRotY * sin(anguloX)
                    val zFinal = y * sin(anguloX) + zRotY * cos(anguloX)

                    // Perspectiva simple (objetos más lejos se ven más pequeños)
                    val factorPerspectiva = 2 / (zFinal + 3)
                    Offset(
                        centro.x + xRotY * escala * factorPerspectiva,
                        centro.y + yRotX * escala * factorPerspectiva
                    )
                }

                // Dibujamos las 12 aristas que forman el cubo
                val aristas = listOf(
                    0 to 1, 1 to 2, 2 to 3, 3 to 0, // Cara frontal
                    4 to 5, 5 to 6, 6 to 7, 7 to 4, // Cara trasera
                    0 to 4, 1 to 5, 2 to 6, 3 to 7  // Laterales
                )

                aristas.forEach { (inicio, fin) ->
                    drawLine(
                        color = colorCubo,
                        start = puntos2D[inicio],
                        end = puntos2D[fin],
                        strokeWidth = 4f
                    )
                }
            }
        }
    }
}