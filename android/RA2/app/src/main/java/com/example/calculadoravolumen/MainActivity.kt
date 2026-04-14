package com.example.calculadoravolumen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aplicamos un tema de Material Design 3
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculadoraVolumenScreen()
                }
            }
        }
    }
}

@Composable
fun CalculadoraVolumenScreen() {
    // Estados para capturar los valores
    var largo by remember { mutableStateOf("") }
    var ancho by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("Introduce los datos") }

    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Cálculo de Volumen",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )

        // Campo Largo
        OutlinedTextField(
            value = largo,
            onValueChange = { largo = it },
            label = { Text("Largo") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true
        )

        // Campo Ancho
        OutlinedTextField(
            value = ancho,
            onValueChange = { ancho = it },
            label = { Text("Ancho") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true
        )

        // Campo Altura
        OutlinedTextField(
            value = altura,
            onValueChange = { altura = it },
            label = { Text("Altura") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Botón de cálculo
        Button(
            onClick = {
                // Reemplazamos coma por punto por si el teclado usa comas
                val l = largo.replace(',', '.').toDoubleOrNull()
                val a = ancho.replace(',', '.').toDoubleOrNull()
                val h = altura.replace(',', '.').toDoubleOrNull()

                if (l != null && a != null && h != null) {
                    val vol = l * a * h
                    resultado = "El volumen es: ${String.format(java.util.Locale.US, "%.2f", vol)} u³"
                   } else {
                    resultado = "Por favor, introduce números válidos"
                }
            },
            modifier = Modifier.fillMaxWidth().height(56.dp)
        ) {
            Text("CALCULAR VOLUMEN")
        }

        // Card para el resultado
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = resultado,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}