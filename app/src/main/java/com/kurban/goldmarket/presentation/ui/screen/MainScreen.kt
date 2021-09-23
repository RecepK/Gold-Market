package com.kurban.goldmarket.presentation.ui.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kurban.goldmarket.presentation.ui.theme.GoldMarketTheme


@Composable
fun MainScreen() {
    Greeting("Android")
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