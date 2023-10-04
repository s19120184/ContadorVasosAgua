package com.example.contadorvasosagua

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel(){
    private  val _tareas=  getWellnessTasks().toMutableStateList()
    val tareas: List <WellnessTask>
        get()=_tareas

    fun remove(elememto: WellnessTask){
        _tareas.remove(elememto)
    }

    fun cambiarTareaCheck(elememto: WellnessTask , checado: Boolean)=
        tareas.find { it.id == elememto.id }?.let { tarea-> tarea.checado=checado }

}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }