package com.example.contadorvasosagua

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import kotlinx.coroutines.withContext

@Composable
fun WellnessScreen(modifier: Modifier = Modifier){

    Column( modifier = modifier) {
        ContadorConEstado()

        val list = remember { getWellnessTasks().toMutableStateList() }
        ListaDeTareas(lista = list , cerrarTarea = {tarea ->list.remove(tarea)})
    }
}
private fun getWellnessTasks()= List(30){ i -> WellnessTask(i,"Tarea # $i")}