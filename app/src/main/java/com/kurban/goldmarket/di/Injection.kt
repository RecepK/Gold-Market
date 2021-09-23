package com.kurban.goldmarket.di

import com.kurban.goldmarket.BuildConfig
import com.kurban.goldmarket.data.remote.Client
import com.kurban.goldmarket.data.repository.RepositoryImp
import com.kurban.goldmarket.domain.usecase.UseCase
import org.jsoup.Jsoup


object Injection {

    fun provideUseCase(): UseCase {
        val jsoup = Jsoup.connect(BuildConfig.API_URL)
        val client = Client(connection = jsoup)
        val repository = RepositoryImp(client = client)
        return UseCase(repository = repository)
    }

    fun provideViewModelFactory(): ViewModelFactory {
        return ViewModelFactory()
    }
}
