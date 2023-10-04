package com.example.contadorvasosagua

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier

private fun getWellnessTask()= List(30){ i -> WellnessTask(i,"Tarea # $i")}

@Composable
fun ListaDeTareas(
    lista: List<WellnessTask> ,
    checkTarea: (WellnessTask ,Boolean)-> Unit,
    onCloseTarea: (WellnessTask) -> Unit,
    modifier: Modifier= Modifier,

){
    LazyColumn( modifier = modifier){
        items(
            items=lista,
            key={tarea-> tarea.id}
        ){tarea->
            WellnessTaskItem(
                nombreTarea = tarea.label ,
                checado = tarea.checado,
                checadoCambia = { check -> checkTarea(tarea, check) },
                cerrar = { onCloseTarea(tarea) } )
        }
    }
}