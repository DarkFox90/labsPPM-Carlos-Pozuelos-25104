package com.example.lab1.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab1.lab04.ui.theme.Lab04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab04Theme(darkTheme = false, dynamicColor = false) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Cuadro1(
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello +  $name!",
        modifier = modifier
    )
}
@Composable
fun Cuadro1(
    modifier: Modifier = Modifier
) {
   Box(
       modifier = modifier
           .fillMaxSize()
   ) {
       Image(
           painter = painterResource(id = R.drawable.logo_uvg),
           contentDescription = "logo uvg fondo",
           alpha = 0.15f,
           contentScale = ContentScale.Fit,
           modifier = Modifier
               .fillMaxSize()
               .padding(64.dp)
       )
       Box( //borde verde
           modifier = Modifier
               .fillMaxSize()
               .border(8.dp, Color(0xFF126E22))

       ) {
           Column( //columna principal
               modifier = Modifier
                   .fillMaxSize()
                   .padding(16.dp),
               horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.SpaceAround

           ) {
               Column(
                   modifier = Modifier,
                   horizontalAlignment = Alignment.CenterHorizontally

               ) {
                   Text(
                       text = "Universidad del Valle de Guatemala",
                       fontWeight = FontWeight.Bold,
                       fontSize = 32.sp,
                       textAlign = TextAlign.Center
                   )

                   Spacer(modifier = Modifier.height(16.dp))

                   Text(
                       text = "Programación de plataformas móviles, Sección 30",
                       fontSize = 24.sp,
                       textAlign = TextAlign.Center
                   )
               }

               Row( // row principal
                   modifier = Modifier
                       .fillMaxWidth()
               ) {
                   Text(
                       text = "INTEGRANTES",
                       fontSize = 20.sp,
                       fontWeight = FontWeight.Bold,
                       textAlign = TextAlign.Start,
                       modifier = Modifier.weight(1f)

                   )

                   Column(
                       modifier = Modifier
                           .weight(1f)
                   ) {
                       Text(
                           text = "Carlos Pozuelos",
                           fontSize = 16.sp,
                       )

                       Text(
                           text = "Andres Castro",
                           fontSize = 16.sp,
                       )

                       Text(
                           text = "Sebastian Garcia",
                           fontSize = 16.sp,
                       )
                   }

               }

               Row(
                   modifier = Modifier
                       .fillMaxWidth()
               ) {
                   Text(
                       text = "CATEDRÁTICO",
                       fontSize = 20.sp,
                       fontWeight = FontWeight.Bold,
                       textAlign = TextAlign.Start,
                       modifier = Modifier.weight(1f)

                   )

                   Column(
                       modifier = Modifier
                           .weight(1f)
                   ) {
                       Text(
                           text = "Juan Carlos Durini",
                           fontSize = 16.sp,

                       )
                   }
               }

               Row(
                   modifier = Modifier
                       .fillMaxWidth(),
                   horizontalArrangement = Arrangement.Center
               ) {
                   Column(
                       modifier = Modifier,
                       horizontalAlignment = Alignment.CenterHorizontally
                   ) {
                       Text(
                           text = "Carlos Pozuelos Mendizábal",
                           fontSize = 16.sp,
                           textAlign = TextAlign.Center
                       )

                       Text(
                           text = "25104",
                           fontSize = 16.sp,
                           textAlign = TextAlign.Center
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
    Lab04Theme {
        Cuadro1(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}