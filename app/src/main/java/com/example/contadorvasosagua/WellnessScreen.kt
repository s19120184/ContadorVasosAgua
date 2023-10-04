package com.example.contadorvasosagua

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.withContext

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel =viewModel()){

    Column( modifier = modifier) {
        ContadorConEstado()

            ListaDeTareas(
                lista=wellnessViewModel.tareas,
                checkTarea ={ task, checked ->
                    wellnessViewModel.cambiarTareaCheck(task, checked)
                },
                onCloseTarea = { tarea -> wellnessViewModel.remove(tarea)}
           )
        //val list = remember { getWellnessTasks().toMutableStateList() }
        //ListaDeTareas(lista = list , cerrarTarea = { tarea ->list.remove(tarea)})
    }
}
