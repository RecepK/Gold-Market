package com.kurban.goldmarket.presentation.ui.screen.main

import androidx.lifecycle.ViewModel
import com.kurban.goldmarket.common.Resource
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
                when (it) {
                    is Resource.Error -> {
                        _state.emit(MainViewState.Error(error = "MainViewModel EmptyList"))
                    }
                    is Resource.Loading -> {
                        _state.emit(MainViewState.Loading)
                    }
                    is Resource.Success -> {
                        _state.emit(MainViewState.Success(value = it.value))
                    }
                }
            }
        }
    }
}