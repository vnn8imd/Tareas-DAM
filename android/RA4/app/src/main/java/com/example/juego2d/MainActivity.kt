package com.example.juego2d

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MemoryGameScreen()
                }
            }
        }
    }
}

@Composable
fun MemoryGameScreen() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    // Estados del juego
    var secuenciaGenerada by remember { mutableStateOf(listOf<Int>()) }
    var secuenciaUsuario by remember { mutableStateOf(mutableListOf<Int>()) }
    var mensaje by remember { mutableStateOf("Pulsa INICIAR") }
    var jugando by remember { mutableStateOf(false) }

    // Recursos de audio
    val sonidos = listOf(R.raw.sonido1, R.raw.sonido2, R.raw.sonido3)

    // Función para reproducir la secuencia de sonidos de forma ordenada
    fun reproducirSecuencia() {
        scope.launch {
            jugando = false
            mensaje = "Escucha la secuencia..."
            secuenciaGenerada = (0..2).shuffled().take(3) // Crea orden aleatorio de 3 sonidos

            secuenciaGenerada.forEach { index ->
                val mp = MediaPlayer.create(context, sonidos[index])
                mp.start()
                delay(800) // Espera entre sonidos para que no se solapen
                mp.release()
            }

            mensaje = "¡Tu turno!"
            secuenciaUsuario = mutableListOf()
            jugando = true
        }
    }

    // Lógica para comprobar si el usuario acertó
    fun verificarPulsacion(index: Int) {
        if (!jugando) return

        val mp = MediaPlayer.create(context, sonidos[index])
        mp.start()
        secuenciaUsuario.add(index)

        if (secuenciaUsuario.size == secuenciaGenerada.size) {
            if (secuenciaUsuario == secuenciaGenerada) {
                mensaje = "¡GANASTE! 🎉"
            } else {
                mensaje = "FALLASTE ❌"
            }
            jugando = false
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = mensaje, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(30.dp))

        // Botones de colores del juego
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Button(onClick = { verificarPulsacion(0) }, colors = ButtonDefaults.buttonColors(containerColor = Color.Red)) { Text("1") }
            Button(onClick = { verificarPulsacion(1) }, colors = ButtonDefaults.buttonColors(containerColor = Color.Green)) { Text("2") }
            Button(onClick = { verificarPulsacion(2) }, colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)) { Text("3") }
        }

        Spacer(modifier = Modifier.height(50.dp))

        // Botón para iniciar partida
        Button(onClick = { reproducirSecuencia() }) {
            Text("INICIAR JUEGO")
        }
    }
}