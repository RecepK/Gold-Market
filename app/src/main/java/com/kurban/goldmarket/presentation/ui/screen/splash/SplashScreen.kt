package com.kurban.goldmarket.presentation.ui.screen.splash

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.kurban.goldmarket.common.Const
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navigate: () -> Unit) {

    Text(text = "SplashScreen")

    LaunchedEffect(key1 = true) {
        delay(Const.SPLASH_DELAY_TIME)
        navigate.invoke()
    }
}
