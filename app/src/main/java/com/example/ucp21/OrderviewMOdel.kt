package com.example.ucp21

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.ucp21.Data.DataClass
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderviewMOdel: ViewModel() {
   var namaMhs : String by mutableStateOf("")
      private set
   var nimmhs: String by mutableStateOf("")
      private set
   var konsen : String by mutableStateOf("")
      private set
   var judul : String by mutableStateOf("")
      private set

   private val _uiState = MutableStateFlow(DataClass())
   val uiState: StateFlow<DataClass> = _uiState.asStateFlow()

   fun insertData(nm: String, Nim: String, Konsen: String, jdl: String){
      namaMhs = nm;
      nimmhs = Nim;
      konsen= Konsen;
      judul= jdl
   }

   fun setDosen(pilihDosen: String){
      _uiState.update {currentState -> currentState.copy(dosen = pilihDosen) }
   }

   fun setDosen1(pilihDosen1: String){
      _uiState.update {currentState -> currentState.copy(dosen = pilihDosen1) }
   }
   }