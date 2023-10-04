package com.example.contadorvasosagua

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contadorvasosagua.ui.theme.ContadorVasosAguaTheme

@Composable
fun WellnessTaskItem(
    nombreTarea: String,
    checado:Boolean,
    checadoCambia: (Boolean)-> Unit,
    cerrar:()->Unit,//recive una funcion
    modifer:Modifier= Modifier
){
    Row(
        modifier= Modifier,
        verticalAlignment= Alignment.CenterVertically
    ){
        Text(
            modifier= Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = nombreTarea
        )
        Checkbox(
            checked = checado,
            onCheckedChange =checadoCambia )
        IconButton(onClick =  { cerrar() } ){
            Icon(
                Icons.Filled.Close ,
                contentDescription="Close"
            )

        }
    }
}

@Composable
fun WellnessTaskItem(
    nombreTarea: String ,
    cerrar: () -> Unit ,
    modifer: Modifier= Modifier){
    var estadoChecked by rememberSaveable { mutableStateOf(false) }

    WellnessTaskItem(
        nombreTarea = nombreTarea,
        checado = estadoChecked,
        checadoCambia = { nuevoValor-> estadoChecked = nuevoValor},
        cerrar = { cerrar() },
        modifer= modifer,
    )


}



@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun ListaPreview() {
    ContadorVasosAguaTheme {
        WellnessTaskItem("tarea",false,{},{})
    }
}
