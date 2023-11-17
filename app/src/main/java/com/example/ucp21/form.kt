package com.example.ucp21

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp21.Data.DataClass
import com.example.ucp21.ui.theme.UCP21Theme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanFrom(OrderviewMOdel: OrderviewMOdel= viewModel(),
){
    var namaTxt by remember { mutableStateOf("") }
    var nimTXT by remember { mutableStateOf("") }
    var konsenTxt by remember { mutableStateOf("") }
    var judulTXT by remember { mutableStateOf("") }

    val context = LocalContext.current
    val dataClass: DataClass
    val uiState by OrderviewMOdel.uiState.collectAsState()
    dataClass = uiState

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "Formulir Pengajuan Skripsi", fontSize = 30.sp, fontWeight = FontWeight.Bold)

        OutlinedTextField(
            value = namaTxt,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            label = {Text(text ="Nama Mahasiswa")},
            onValueChange ={
                namaTxt=it}
        )

        OutlinedTextField(
            value = nimTXT,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            label = {Text(text ="NIM")},
            onValueChange ={
                nimTXT=it}
        )

        OutlinedTextField(
            value = konsenTxt,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            label = {Text(text ="Konsentrasi")},
            onValueChange ={
                konsenTxt=it}
        )

        OutlinedTextField(
            value = judulTXT,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            label = {Text(text ="Judul Skripsi")},
            onValueChange ={
                judulTXT=it}
        )
        
        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = {OrderviewMOdel.insertData(namaTxt,nimTXT,konsenTxt,judulTXT)}) {
            Text(text = stringResource(id = R.string.submit))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHalamanFrom(){
    UCP21Theme {
       HalamanFrom()
    }
}