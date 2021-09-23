package com.kurban.goldmarket.presentation.ui.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kurban.goldmarket.di.Injection
import com.kurban.goldmarket.presentation.MainViewModel
import com.kurban.goldmarket.presentation.MainViewState
import com.kurban.goldmarket.presentation.ui.theme.GoldMarketTheme


@Composable
fun MainScreen() {
    val viewModel: MainViewModel = viewModel(factory = Injection.provideViewModelFactory())
    val state = viewModel.state.collectAsState()

    val value = when (val stateValue = state.value) {
        is MainViewState.Error -> "Error: ${stateValue.error}"
        MainViewState.Loading -> "Loading"
        is MainViewState.Success -> "Success: ${stateValue.data?.size} "
    }

    Greeting("Android: $value")
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GoldMarketTheme {
        Greeting("Android")
    }
}