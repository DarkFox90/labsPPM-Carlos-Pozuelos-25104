package com.example.lab1.lab05

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.ToggleButton
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Icon(
                painter = painterResource(R.drawable.ic_refresh1),
                contentDescription = "icono de actualizacion",
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = "Actualización disponible",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(2f),
                color = MaterialTheme.colorScheme.onPrimary
            )

            TextButton(
                onClick = {
                    val link = android.net.Uri.parse("https://play.google.com/store/apps/details?id=com.spotify.music&hl=es_419")
                    val intent = android.content.Intent(android.content.Intent.ACTION_VIEW, link)
                    context.startActivity(intent)
                }
            ) {
                Text(
                    text = "Descargar",
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }

        }
        Row( //fecha de cumpleaños
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = "Jueves",
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp
                )

                Text(
                    text = "24 de Septiembre",
                    fontSize = 18.sp
                )
            }

            OutlinedButton(
                onClick = {},
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Terminar jornada",
                    color = Color(0xFFE11010)
                )
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)

        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
               Row(
                   modifier = Modifier
                       .fillMaxWidth(),
                   verticalAlignment = Alignment.CenterVertically,
               ) {
                   Text(
                       text = "Graciela",
                       fontSize = 32.sp,
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier.weight(1f)
                   )

                   IconButton(
                       onClick = {
                           val mapUri = android.net.Uri.parse("geo:0,0?q=14.592072172451795, -90.49146779007258(Graciela)")
                           val mapIntent = android.content.Intent(android.content.Intent.ACTION_VIEW, mapUri)
                           mapIntent.setPackage("com.google.android.apps.maps")
                           context.startActivity(mapIntent)
                       }
                   ) {
                       Icon(
                           painter = painterResource(R.drawable.ic_direction),
                           contentDescription = "icono de direccion ",
                           tint = Color(0xFF4FE871),
                           modifier = Modifier.size(28.dp)
                       )
                   }
               }
                Text(
                    text = "Vidére, Blvd. Vista Hermosa zona 15",
                    fontSize = 16.sp,
                )

                Text(
                    text = "6:30AM  9:00PM",
                    fontSize = 16.sp,
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            Toast.makeText(
                                context,
                                "Carlos Pozuelos Mendizábal",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .width(160.dp)
                            .weight(1f)
                    ) {
                        Text(
                            text = "Iniciar"
                        )
                    }

                    TextButton(
                        onClick = {
                            Toast.makeText(
                                context,
                                "Comfort food \nNormal (QQ)",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Text(
                            text = "detalles"
                        )
                    }
                }

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