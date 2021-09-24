package com.kurban.goldmarket.presentation.ui.screen.main

import androidx.lifecycle.ViewModel
import com.kurban.goldmarket.domain.usecase.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class MainViewModel(private val useCase: UseCase) : ViewModel() {

    private val _state: MutableStateFlow<MainViewState> = MutableStateFlow(MainViewState.Loading)
    val state: StateFlow<MainViewState> = _state

    init {
        getGoldList()
    }

    private fun getGoldList() {
        CoroutineScope(Dispatchers.IO).launch {
            useCase.getGoldList().collect {
                val list = it.data

                list?.let {
                    _state.emit(MainViewState.Success(value = list))
                } ?: run {
                    _state.emit(MainViewState.Error(error = "MainViewModel EmptyList"))
                }
            }
        }
    }
}