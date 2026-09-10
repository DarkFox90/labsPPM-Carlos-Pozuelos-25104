package com.example.lab1.lab06

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab1.lab06.ui.theme.Lab06Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.grid.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab06Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaContador(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PantallaContador (modifier: Modifier = Modifier) {
    var valorActual by rememberSaveable { mutableIntStateOf(0) }
    var incrementosTotales by rememberSaveable {mutableIntStateOf(0) }
    var decrementosTotales by rememberSaveable {mutableIntStateOf(0)}
    var valorMax by rememberSaveable {mutableIntStateOf(0) }
    var valorMin by rememberSaveable { mutableIntStateOf(0) }

    var historial by rememberSaveable {mutableStateOf(listOf<Pair<Int, Boolean>>()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text (
            text = "Carlos Pozuelos Mendizábal",
            fontSize = 28.sp,
            modifier = Modifier.padding(bottom = 32.dp),
            textAlign = TextAlign.Center
        )

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            FilledIconButton (
                onClick = {
                    valorActual--
                    decrementosTotales++

                    if (valorActual < valorMin) {
                        valorMin = valorActual
                    }
                    historial = historial + Pair(valorActual, false)
                },
                modifier = Modifier.size(56.dp)
            ) {
                Text(
                    text = "-",
                    fontSize = 36.sp
                )
            }

            Text(
                text = "$valorActual",
                fontSize = 72.sp,
                fontWeight = FontWeight.Medium
            )

            FilledIconButton(
                onClick = {
                    valorActual++
                    incrementosTotales++

                    if (valorActual > valorMax) {
                        valorMax = valorActual
                    }
                    historial = historial + Pair(valorActual, true)
                },
                modifier = Modifier.size(56.dp)
            ) {
                Text(
                    text = "+",
                    fontSize = 36.sp,

                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Estadisticas(etiqueta = "Total incrementos:", valor = incrementosTotales)
            Estadisticas(etiqueta = "Total decrementos:", valor = decrementosTotales)
            Estadisticas(etiqueta = "Valor máximo:", valor = valorMax)
            Estadisticas(etiqueta = "Total minimo:", valor = valorMin)
            Estadisticas(etiqueta = "Total cambios:", valor = incrementosTotales + decrementosTotales)
        }

        Text(
            text = "Historial:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(5),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(historial) { pareja ->
                Box(
                    modifier = Modifier
                        .size(46.dp)

                        .background (
                            if (pareja.second) {
                                Color(0xFF2E7D32)
                            } else {
                                Color(0xFFC62828)
                            },
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "${pareja.first}",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun Estadisticas(etiqueta: String, valor: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = etiqueta,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "$valor",
            fontSize = 20.sp

        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab06Theme {
        PantallaContador()
    }
}