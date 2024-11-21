package com.example.navigationwithmvvm
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationwithmvvm.model.DataJenisKelamin
import com.example.navigationwithmvvm.ui.view.DetailMahasiswaView
import com.example.navigationwithmvvm.ui.view.FormMahasiswaView
import com.example.navigationwithmvvm.ui.viewmodel.MahasiswaViewModel

enum class Halaman{
    Formulir,
    Detail,
}

@Composable
fun PengelolaHalaman(
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navHostController: NavHostController = rememberNavController()
){
    Scaffold { isipadding ->
        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            modifier = modifier.padding(isipadding),
            navController = navHostController, startDestination = Halaman.Formulir.name
        ){
            composable(route = Halaman.Formulir.name){
                val konteks = LocalContext.current
                FormMahasiswaView(
                    listJK = DataJenisKelamin.listJK.map {
                            isi -> konteks.resources.getString(isi)
                    },
                    onSubmitClicked = {
                        viewModel.saveDataMahasiswa(it)
                        navHostController.navigate(Halaman.Detail.name)
                    }
                )
            }
            composable(route = Halaman.Detail.name) {
                DetailMahasiswaView(
                    uiStateMahasiswa = uiState,
                    navHostController = navHostController
                )
            }
        }
    }

}