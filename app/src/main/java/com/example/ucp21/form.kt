package com.example.ucp21

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp21.Data.DataClass
import com.example.ucp21.ui.theme.UCP21Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanFrom(orderviewMOdel: OrderviewMOdel= viewModel(),
    onSubmitButtonClicked: (MutableList<String>)-> Unit
){
    var namaTxt by remember { mutableStateOf("") }
    var nimTXT by remember { mutableStateOf("") }
    var konsenTxt by remember { mutableStateOf("") }
    var judulTXT by remember { mutableStateOf("") }

    val context = LocalContext.current
    val dataFrom: DataClass
    val uiState by OrderviewMOdel.ui.collectAsState()
    dataFrom = uiState
    var listData: MutableList<String> = mutableListOf(namaTxt, nimTXT, konsenTxt,judulTXT)
    
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        OutlinedTextField(value = namaTxt, onValueChange = { namaTxt = it }, label = {
            Text(text = stringResource(id = R.string.name))
        })
        OutlinedTextField(value = nimTXT, onValueChange = { nimTXT = it }, label = {
            Text(text = stringResource(id = R.string.nim))
        })
        OutlinedTextField(value = konsenTxt, onValueChange = { konsenTxt = it }, label = {
            Text(text = stringResource(id = R.string.konsen))
        })

        OutlinedTextField(value = judulTXT, onValueChange = { judulTXT = it }, label = {
            Text(text = stringResource(id = R.string.jdlskrip))
        })
        
        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = {onSubmitButtonClicked(listData)}) {
            Text(text = stringResource(id = R.string.submit))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHalamanFrom(){
    UCP21Theme {
       HalamanFrom(onSubmitButtonClicked = {})
    }
}