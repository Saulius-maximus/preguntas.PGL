package com.example.preguntas

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.preguntas.ui.theme.PreguntasTheme

class MainActivity : ComponentActivity() {
    
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreguntasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Greeting(

                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val Q1 = "Somebody once told me?"
    val Q2 = "The world is gonna roll me?"
    val Q3 = "I am the sharpest tool in the shed?"
    val Q4 = "She was looking kinda dumb?"
    val Q5 = "With her index and her thumb?"
    val Q6 = "With the shape of an L in her forehead?"

    val A1 = true
    val A2 = true
    val A3 = false
    val A4 = true
    val A5 = false
    val A6 = true

    val F1 = R.drawable.shrek
    val F2 = R.drawable.world
    val F3 = R.drawable.tool
    val F4 = R.drawable.dum
    val F5 = R.drawable.tijeras
    val F6 = R.drawable.l

    val P1 = Pregunta(Q1, A1, F1)
    val P2 = Pregunta(Q2, A2, F2)
    val P3 = Pregunta(Q3, A3, F3)
    val P4 = Pregunta(Q4, A4, F4)
    val P5 = Pregunta(Q5, A5, F5)
    val P6 = Pregunta(Q6, A6, F6)

    val p = arrayListOf<Pregunta>()

    p.add(P1)
    p.add(P2)
    p.add(P3)
    p.add(P4)
    p.add(P5)
    p.add(P6)

    var num by remember { mutableIntStateOf(0) }
    val imagen = p[num].foto
    var Texto by remember { mutableStateOf("") }
    var color by remember { mutableStateOf(Color.Green) }

    Column(verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)) {
        Row(
            horizontalArrangement = Arrangement.Absolute.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = p[num].texto,
                fontSize = 30.sp
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 15.dp)
        ) {

                Image(
                    painter = painterResource(imagen),
                    contentDescription = "",
                    modifier = Modifier
                        .size(400.dp)
                )
        }

        Column(

            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    Texto,
                    color = color,
                    fontSize = 24.sp
                )
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        if (p[num].respuesta){
                            Texto = "Respuesta Correcta"
                            color = Color.Green
                        }else{
                            Texto = "Respuesta Incorrecta"
                            color = Color.Red
                        }
                }) {
                    Text("True")
                }

                Spacer(
                    modifier= Modifier.width(20.dp)
                )

                Button(
                    onClick = {
                        if (!p[num].respuesta){
                            Texto = "Respuesta Correcta"
                            color = Color.Green
                        }else{
                            Texto = "Respuesta Incorrecta"
                            color = Color.Red
                        }
                    }) {
                    Text("False")
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()

            ) {


                Button(
                    modifier = Modifier.fillMaxWidth()
                        .weight(1f),
                    onClick = {
                        if (num==0){
                            num=5
                        }else{
                            num--
                        }
                        Texto = ""
                    }
                ) {
                    Text("Prev")
                }

                Button(
                    modifier = Modifier.fillMaxWidth()
                        .weight(1f),
                    onClick = {
                        if (num==5){
                            num=0
                        }else{
                            num++
                        }
                        Texto = ""
                    }
                ) {
                    Text("Next")
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview(){
    MaterialTheme{
        Surface(modifier= Modifier.fillMaxSize()) {
            Greeting()
        }
    }
}