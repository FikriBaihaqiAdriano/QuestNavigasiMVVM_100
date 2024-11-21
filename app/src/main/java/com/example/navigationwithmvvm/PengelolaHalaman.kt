package com.example.navigationwithmvvm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.navigationwithmvvm.ui.viewmodel.MahasiswaViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import com.example.navigationwithmvvm.model.DataJenisKelamin
import com.example.navigationwithmvvm.ui.view.FormMahasiswaView

enum class Halaman{
    Formulir,
    Detail,
}


@Composable
fun PengelolaHalaman(
    navController: NavController = rememberNavController(),
    viewModel : MahasiswaViewModel = viewModel()
){

    val stateUI by viewModel.uiState.collectAsState()

    NavHost(navController = navController, startDestination = Halaman.Formulir.name) {
        composable(route = Halaman.Formulir.name) {
            val konteks = LocalContext.current
            FormMahasiswaView(
                listJK = DataJenisKelamin.listJK.map {id ->
                    konteks.resources.getString(
                        id
                    )
                },
                onSubmitClicked = {}
            )
        }
    }
}