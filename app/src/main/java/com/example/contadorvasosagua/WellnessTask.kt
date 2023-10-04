package com.example.contadorvasosagua

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class WellnessTask(
     val id : Int ,
     val label: String ,
     inicialCkeck: Boolean= false){

     var checado by mutableStateOf(inicialCkeck)

 }

