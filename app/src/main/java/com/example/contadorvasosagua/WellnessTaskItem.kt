package com.example.contadorvasosagua

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WellnessTaskItem(
    nombreTarea: String,
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
        IconButton(onClick =  cerrar ){
            Icon(
                Icons.Filled.Close ,
                contentDescription="Close"
            )

        }
    }
}