package com.example.navigationwithmvvm.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.navigationwithmvvm.model.DataMahasiswa

@Composable
fun FormMahasiswaView(
    modifier: Modifier = Modifier,
    listJK: List<String>,
    onSubmitClicked: (MutableList<String>) -> Unit
){
    var nama by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }

    val dataMahasiswa : MutableList<String> = mutableListOf(nama, nim, selectedGender,alamat)

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Biodata")
        Spacer(modifier = Modifier.padding(5.dp))
        OutlinedTextField(value = nama,
            onValueChange = {nama = it},
            placeholder = { Text("Masukkan nama anda")
            }, label = { Text("Nama") }
            ,modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp))

        Spacer(modifier = Modifier.padding(5.dp))
        OutlinedTextField(value = nim,
            onValueChange = {nim = it},
            placeholder = { Text("Masukkan Nim")
            }, label = {Text("Nim")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(5.dp))

        Row (){
            listJK.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically){ RadioButton(
                    selected = selectedGender == item,
                    onClick = {
                        selectedGender = item
                    })
                    Text(item)
                }
            }
        }

        OutlinedTextField(value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text("Masukkan Alamat")
            }, label = {Text("Alamat")},
            modifier = Modifier.fillMaxWidth().padding(5.dp))

        Button(onClick = {onSubmitClicked(dataMahasiswa)})
        {
            Text("Simpan")
        }

    }
}
