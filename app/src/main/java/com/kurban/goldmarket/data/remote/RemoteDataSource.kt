package com.kurban.goldmarket.data.remote

import com.kurban.goldmarket.common.Resource
import com.kurban.goldmarket.data.model.toModel
import com.kurban.goldmarket.domain.model.Model
import com.kurban.goldmarket.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class RemoteDataSource(private val api: Api) : Repository {

    override fun getGoldList(): Flow<Resource<List<Model>>> = flow<Resource<List<Model>>> {
        val response = api.getList()
        when (response.isSuccessful) {
            false -> {
                emit(Resource.Error(error = "Fail ResponseException"))
            }
            true -> {
                response.body()?.let { list ->
                    emit(Resource.Success(value = list.map { it.toModel() }))
                } ?: run {
                    emit(Resource.Error(error = "Null ResponseException"))
                }
            }
        }
    }.catch {
        emit(Resource.Error(error = "Flow ResponseException"))
    }.flowOn(Dispatchers.IO)
}