package com.kurban.goldmarket.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kurban.goldmarket.presentation.MainViewModel


class ViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(useCase = Injection.provideUseCase()) as T
            else -> throw Exception(message = "ViewModelFactory Exception")
        }
    }
}