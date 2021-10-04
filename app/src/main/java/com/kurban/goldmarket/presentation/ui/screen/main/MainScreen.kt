package com.kurban.goldmarket.presentation.ui.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kurban.goldmarket.di.Injection
import com.kurban.goldmarket.domain.model.Model


@Composable
fun MainScreen(onClick: (Model) -> Unit) {
    val viewModel: MainViewModel = viewModel(factory = Injection.provideViewModelFactory())
    val state = viewModel.state.collectAsState().value
    var visibleState: MainViewState by remember { mutableStateOf(state) }
    visibleState = state

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        when (visibleState) {
            is MainViewState.Error -> {
                ComposeText(text = "Error")
            }
            is MainViewState.Loading -> {
                ComposeText(text = "Loading")
            }
            is MainViewState.Success -> {
                SampleComposable(state.data!!, onClick)
            }
        }
    }
}

@Composable
fun SampleComposable(list: List<Model>, onClick: (Model) -> Unit) {
    Scaffold {
        LazyColumn {
            items(list) { model ->
                ComposeRow(model = model, onClick = onClick)
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

@Composable
fun ComposeTitleText(text: String) {
    ComposeText(
        text = text,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue)
    )
}

@Composable
fun ComposeText(
    text: String,
    color: Color = Color.Black,
    modifier: Modifier = Modifier.padding(vertical = 4.dp)
) {
    Text(
        text = text,
        fontSize = 16.sp,
        color = color,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Composable
fun ComposeRow(model: Model, onClick: (Model) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.clickable { onClick.invoke(model) }
        )
        {
            ComposeTitleText(text = "${model.name}")
            ComposeText(text = "Alış:${model.buy}")
            ComposeText(text = "Satış:${model.sell}")
            ComposeText(text = "⏳ ${model.time}")
            ComposeDivider()
        }
    }
}