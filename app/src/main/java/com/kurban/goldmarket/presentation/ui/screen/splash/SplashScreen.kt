package com.kurban.goldmarket.presentation.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.kurban.goldmarket.R
import com.kurban.goldmarket.common.Const
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navigate: () -> Unit) {

    LaunchedEffect(key1 = true) {
        delay(Const.SPLASH_DELAY_TIME)
        navigate.invoke()
    }

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "image",
                modifier = Modifier.scale(1F)
            )
        }
        Text(text = stringResource(id = R.string.app_name))
    }
}
