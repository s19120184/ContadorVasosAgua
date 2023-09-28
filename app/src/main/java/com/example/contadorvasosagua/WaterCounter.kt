package com.example.contadorvasosagua

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier){

    var contador by remember {
        mutableStateOf(0)
    }
    
    Column ( 
        modifier=modifier.padding(16.dp)
    ) {

        if (contador > 0) {
            var mostrarTarea by remember { mutableStateOf(true) }

            if (mostrarTarea) {
                WellnessTaskItem(nombreTarea = "Camina mucho", cerrar = { mostrarTarea = false })
            }

            Text(text = "you've had $contador glasses",)
        }

        Row(Modifier.padding(top = 8.dp)) {
            Button(
                onClick = { contador++ },
                Modifier.padding(top = 8.dp),
                enabled = contador < 10 // boton abilitado mietras el contador sea menor a 10
              )
            {
                Text(text = "Agrega Uno")
            }
            Button(
                onClick = {contador=0 },
                Modifier.padding(start = 8.dp)
            ) {
                Text(text = "contador de agua Limdspiado")
            }

        }
    }
}