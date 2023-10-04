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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contadorvasosagua.ui.theme.ContadorVasosAguaTheme

@Composable
fun WaterCounter(modifier: Modifier = Modifier){

    var contador by rememberSaveable {
        mutableStateOf(0)
    }
    
    Column ( 
        modifier=modifier.padding(16.dp)
    ) {

        if (contador > 0) {
            /*var mostrarTarea by rememberSaveable { mutableStateOf(true) }

            if (mostrarTarea) {
                WellnessTaskItem(nombreTarea = "Camina mucho", cerrar = { mostrarTarea = false })
            }*/

            Text(text = "you've had $contador glasses",)
        }

        Row(Modifier.padding(top = 8.dp)) {
            Button(
                onClick = { contador++ },
                enabled = contador < 10 // boton abilitado mietras el contador sea menor a 10
            )
            {
                Text(text = "Agrega Uno")
            }
            Button(
                onClick = { contador = 0 },
                Modifier.padding(start = 8.dp)
            ) {
                Text(text = "Limpiar contador agua")
            }

        }
    }
}
@Composable
fun ContadorSinEstado(
    contador : Int ,
    funcionIncrementar: () ->Unit,
    modifier: Modifier=Modifier){
    
    Column(modifier = modifier.padding(16.dp)) {
        if(contador>0){
            Text(text = "has tomado $contador vasos")
        }
        Button(
            onClick = { funcionIncrementar() },
            Modifier.padding(8.dp),
            enabled= contador<10) {
            Text(text = "Agrega uno")
        }
    }
    
}
@Composable
fun ContadorConEstado(modifier: Modifier= Modifier){
    var contador by rememberSaveable {
        mutableStateOf(0)
    }

    ContadorSinEstado(contador =contador, funcionIncrementar = { contador++ }, modifier =modifier )
    }

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun ContadorvasosPreview() {
    ContadorVasosAguaTheme {
        ContadorSinEstado(contador = 0, funcionIncrementar = { /*TODO*/ })
    }
}

