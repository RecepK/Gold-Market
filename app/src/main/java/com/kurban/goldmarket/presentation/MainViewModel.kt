package com.kurban.goldmarket.presentation

import androidx.lifecycle.ViewModel
import com.kurban.goldmarket.domain.usecase.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class MainViewModel(private val useCase: UseCase) : ViewModel() {

    init {
        getGoldList()
    }

    private fun getGoldList() {
        CoroutineScope(Dispatchers.IO).launch {
            useCase.getGoldList().collect {
                    list ->
            }
        }
    }
}