package com.kurban.goldmarket.di

import com.kurban.goldmarket.BuildConfig
import com.kurban.goldmarket.data.remote.Api
import com.kurban.goldmarket.data.remote.RemoteDataSource
import com.kurban.goldmarket.data.repository.RepositoryImp
import com.kurban.goldmarket.domain.usecase.UseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Injection {

    private fun provideApiClient(): Api {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    fun provideUseCase(): UseCase {
        val remoteDataSource = RemoteDataSource(api = provideApiClient())
        val repository = RepositoryImp(remoteDataSource = remoteDataSource)
        return UseCase(repository = repository)
    }

    fun provideViewModelFactory(): ViewModelFactory {
        return ViewModelFactory()
    }
}
