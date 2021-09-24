package com.kurban.goldmarket.presentation.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kurban.goldmarket.di.Injection
import com.kurban.goldmarket.domain.model.Model
import com.kurban.goldmarket.presentation.MainViewModel
import com.kurban.goldmarket.presentation.MainViewState


@Composable
fun MainScreen(onClick: (Model) -> Unit) {
    val viewModel: MainViewModel = viewModel(factory = Injection.provideViewModelFactory())
    val state = viewModel.state.collectAsState()

    val stateValue = state.value

    val value = when (stateValue) {
        is MainViewState.Error -> "Error: ${stateValue.error}"
        is MainViewState.Loading -> "Loading"
        is MainViewState.Success -> "Success: ${stateValue.data?.size} "
    }

    Scaffold {
        Column(modifier = Modifier.verticalScroll(state = rememberScrollState())) {
            stateValue.data?.forEach { model ->
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.clickable { onClick.invoke(model) })
                    {
                        Text(text = "${model.name}")
                        Text(text = "Alış:${model.buy}")
                        Text(text = "Satış:${model.sell}")
                        Text(text = "⏳ ${model.time}")
                        ComposeDivider()
                    }
                }
            }
        }
    }
}

@Composable
fun ComposeDivider() {
    Divider(
        color = Color.Black,
        modifier = Modifier
            .fillMaxWidth()
            .width(1.dp)
    )
}