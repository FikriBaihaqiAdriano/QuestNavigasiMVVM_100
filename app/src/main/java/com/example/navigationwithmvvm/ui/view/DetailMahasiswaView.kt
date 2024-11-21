package com.example.navigationwithmvvm.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.navigationwithmvvm.model.DataMahasiswa

@Composable
fun DetailMahasisawaView(
    modifier: Modifier = Modifier,
    uiStateMahasiswa: DataMahasiswa,
){
    val listDataMhs = listOf(
        Pair("Nama", uiStateMahasiswa.nama),
        Pair("Gender", uiStateMahasiswa.gender),
        Pair("Alamat", uiStateMahasiswa.alamat),
    )

    Column() {
        listDataMhs.forEach {
            CardSection(
                judulParam = items.first,
                isiParam = items.second
            )
        }
    }
}
