package com.example.reproductor

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ReproductorScreen()
                }
            }
        }
    }
}

@Composable
fun ReproductorScreen() {
    val context = LocalContext.current

    // Inicialización del MediaPlayer vinculada al ciclo de vida de la pantalla
    // Usamos remember para que el objeto no se recree en cada cambio de estado
    val mediaPlayer = remember {
        MediaPlayer.create(context, R.raw.musica_proyecto)
    }

    // Variable de estado para mostrar el texto de lo que está ocurriendo
    var estadoTexto by remember { mutableStateOf("Listo para reproducir") }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "App de Sonido - RA3", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = estadoTexto, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(40.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            // BOTÓN REPRODUCIR [cite: 68]
            Button(onClick = {
                mediaPlayer.start()
                estadoTexto = "Reproduciendo..."
            }) { Text("Reproducir") }

            // BOTÓN PAUSAR: Guarda la posición actual para reanudar después [cite: 69]
            Button(onClick = {
                if (mediaPlayer.isPlaying) {
                    mediaPlayer.pause()
                    estadoTexto = "Pausado"
                }
            }) { Text("Pausar") }

            // BOTÓN DETENER: Detiene y reinicia el audio al principio
            Button(onClick = {
                mediaPlayer.stop()
                mediaPlayer.prepare() // Necesario para volver a usar el reproductor tras stop()
                mediaPlayer.seekTo(0) // Asegura que inicie desde el principio
                estadoTexto = "Detenido"
            }) { Text("Detener") }
        }
    }

    // Aseguramos liberar los recursos cuando la app se cierre para evitar consumo de batería
    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.release()
        }
    }
}