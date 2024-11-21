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

@Composable
fun FormMahasiswaView(
    modifier: Modifier = Modifier,
    listJK: List<String>,
    onSubmitClicked: () -> Unit
){
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf( "") }
    var alamat by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }

    val jenisKelamin = listOf("Laki-laki", "Perempuan")
    var namaUser by remember { mutableStateOf("") }
    var emailUser by remember { mutableStateOf( "") }
    var alamatUser by remember { mutableStateOf("") }
    var noHpUser by remember { mutableStateOf("") }
    var selectedGenderUser by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally){
        OutlinedTextField(value = nama,
            onValueChange = {nama = it},
            placeholder = { Text("Masukkan nama anda")
            }, label = { Text("Nama") }
            ,modifier = Modifier.fillMaxWidth().padding(5.dp))
        Row {
            jenisKelamin.forEach { item ->
                Row(verticalAlignment = Alignment.CenterVertically){ RadioButton(
                    selected = selectedGender == item,
                    onClick = {
                        selectedGender = item
                    })
                    Text(item)
                }
            }
        }

        OutlinedTextField(value = email,
            onValueChange = {email = it},
            placeholder = { Text("Masukkan Email anda")
            }, label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            ,modifier = Modifier.fillMaxWidth().padding(5.dp))

        OutlinedTextField(value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text("Masukkan Alamat anda")
            }, label = { Text("Alamat") }
            ,modifier = Modifier.fillMaxWidth().padding(5.dp))

        OutlinedTextField(value = noHp,
            onValueChange = {noHp = it},
            placeholder = { Text("Masukkan noHp anda")
            }, label = { Text("NoHp") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            ,modifier = Modifier.fillMaxWidth().padding(5.dp))

        Button(onClick = {
            namaUser = nama
            emailUser = email
            alamatUser = alamat
            noHpUser = noHp
            selectedGenderUser = selectedGender

        }) { Text("Simpan") }
        Card(modifier.size(width = 300.dp, height = 200.dp)){
            MainSection(params = "Nama", isiparms = namaUser)
            MainSection(params = "Email", isiparms = emailUser)
            MainSection(params = "Alamat", isiparms = alamatUser)
            MainSection(params = "NoHp", isiparms = noHpUser)
            MainSection(params = "jenis kelamin", isiparms = selectedGenderUser)
        }

    }

}
@Composable
fun MainSection(params: String, isiparms: String){
    Column(horizontalAlignment = Alignment.Start){

        Row(modifier = Modifier.fillMaxWidth().padding(2.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = params, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(
                text = "$isiparms",
                modifier = Modifier.weight(2f))
        }
    }
}