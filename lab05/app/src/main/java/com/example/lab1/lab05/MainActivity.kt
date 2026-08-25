package com.example.lab1.lab05

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab1.lab05.ui.theme.Lab05Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab05Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    layout(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun layout(
    modifier: Modifier = Modifier
) {
    Column( //columna principal
        modifier = modifier.fillMaxSize()
    ) {
        val context = LocalContext.current
        val modoOscuro = isSystemInDarkTheme()
        val colorFondo = if (modoOscuro) Color(0xFF58C4E8) else Color(0xFF53A4E7)
        val colorContenido = if (modoOscuro) Color(0xFF54646B) else Color(0xFF15ABE1)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorFondo),
            verticalAlignment = Alignment.CenterVertically

        ) {
            //pendiente icono
            Icon(
                painter = painterResource(R.drawable.ic_refresh1),
                contentDescription = "icono de actualizacion",
                tint = colorContenido
            )

            Text(
                text = "Actualización disponible",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f),
                color = colorContenido
            )

            TextButton(
                onClick = {
                    val link = android.net.Uri.parse("https://play.google.com/store/apps/details?id=com.spotify.music&hl=es_419")
                    val intent = android.content.Intent(android.content.Intent.ACTION_VIEW, link)
                    context.startActivity(intent)
                }
            ) {
                Text("Descargar")
            }

        }
    }



}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab05Theme {
        layout()
    }
}