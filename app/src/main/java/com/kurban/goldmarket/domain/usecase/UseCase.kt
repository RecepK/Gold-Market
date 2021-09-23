package com.kurban.goldmarket.domain.usecase

import com.kurban.goldmarket.common.Resource
import com.kurban.goldmarket.domain.model.Model
import com.kurban.goldmarket.domain.repository.Repository
import kotlinx.coroutines.flow.flow


class UseCase(private val repository: Repository) {

    fun getGoldList() = flow<Resource<List<Model>>> {
        try {
            //emit(Resource.Loading())
            emit(Resource.Success(value = repository.getGoldList()))
        } catch (e: Exception) {
            emit(Resource.Error(error = "GoldMarket UseCase Exception: ${e.localizedMessage}"))
        }
    }
}