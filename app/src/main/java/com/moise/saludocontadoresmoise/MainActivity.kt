package com.moise.saludocontadoresmoise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moise.saludocontadoresmoise.ui.theme.SaludoContadoresMoiseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainButtons()
        }
    }

}

@Composable
fun mainButtons(){
    var text by remember { mutableStateOf("Hola,") }
    var showDialog by remember { mutableStateOf(false) }

    if (!showDialog){
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Button(
                modifier = Modifier
                    .height(70.dp)
                    .width(210.dp)
                    .padding(5.dp),
                shape = RectangleShape,
                onClick = {
                    showDialog = true
                    text="Hola,"
                }) {
                Text(text = "Saludar")
            }
            if (text.length !=5){
                Box(
                    modifier = Modifier
                        .height(55.dp)
                        .width(200.dp)
                        .background(color = Color.LightGray),
                ){
                    Text(text = text)
                }
            }

        }
    }
    else{
        val list= Dialog()
        if (list[1] as Boolean){
            text += list[0].toString()
            showDialog = false
        }

    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun Dialog(): MutableList<Any> {
    var myval by remember { mutableStateOf("") }
    var cerrar by remember { mutableStateOf(false) }

    AlertDialog(
        title = { Text(text = "Configuracion")},
        text = {
            Column {
                OutlinedTextField(
                    value = myval,
                    label = {Text("Introduce tu nombre")},
                    onValueChange = {
                        myval = it
                    })
                Row(){
                    Button(
                        modifier = Modifier
                        .height(40.dp)
                        .width(90.dp)
                        .padding(top = 4.dp)
                        .padding(2.dp),
                        shape = RectangleShape,onClick = {
                        cerrar = true
                    }) {
                        Text(text = "Aceptar", fontSize = 9.sp)
                    }
                    Button(
                        modifier = Modifier
                            .height(40.dp)
                            .width(90.dp)
                            .padding(top = 4.dp)
                            .padding(2.dp),
                        shape = RectangleShape,onClick = {
                        myval = ""
                    }) {
                        Text(text = "Limpiar", fontSize = 9.sp)
                    }
                    Button(
                        modifier = Modifier
                            .height(40.dp)
                            .width(90.dp)
                            .padding(top = 4.dp)
                            .padding(2.dp),
                        shape = RectangleShape,onClick = {
                        myval=""
                        cerrar = true
                    }) {
                        Text(text = "Cancelar", fontSize = 9.sp)
                    }
                }
            }
        },
        onDismissRequest = {

        },
        confirmButton = {

        })
    return mutableListOf(myval,cerrar)
}