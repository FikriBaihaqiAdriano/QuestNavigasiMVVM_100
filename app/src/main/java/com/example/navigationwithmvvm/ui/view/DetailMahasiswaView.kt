package com.example.navigationwithmvvm.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.navigationwithmvvm.model.DataMahasiswa

@Composable
fun DetailMahasiswaView(
    modifier: Modifier = Modifier,
    uiStateMahasiswa: DataMahasiswa,
    navHostController: NavHostController
){
    val listDataMahasiswa = listOf(
        Pair("Nama", uiStateMahasiswa.nama),
        Pair("Nim", uiStateMahasiswa.nim),
        Pair("Gender", uiStateMahasiswa.gender),
        Pair("Alamat", uiStateMahasiswa.alamat),
    )
    IconButton(
        onClick = { navHostController.popBackStack() },
    ) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
    }
    Column (modifier = Modifier.padding(15.dp)){
        listDataMahasiswa.forEach{items ->
            CardSection(
                Judul = items.first,
                IsiJudul = items.second
            )
        }
    }
}

@Composable
fun CardSection(Judul:String, IsiJudul:String){
    Column (horizontalAlignment = Alignment.Start){

        Spacer(modifier = Modifier.padding(20.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = Judul, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = IsiJudul, modifier = Modifier.weight(2f)
            )
        }

    }
}
