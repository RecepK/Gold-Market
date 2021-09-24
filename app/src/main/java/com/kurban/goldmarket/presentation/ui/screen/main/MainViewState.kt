package com.kurban.goldmarket.presentation.ui.screen.main

import com.kurban.goldmarket.domain.model.Model


sealed class MainViewState(val data: List<Model>? = null, val message: String? = null) {
    object Loading : MainViewState()
    data class Success(val value: List<Model>) : MainViewState(data = value)
    data class Error(val error: String) : MainViewState(message = error)
}