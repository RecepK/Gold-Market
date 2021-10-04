package com.kurban.goldmarket.data.repository

import com.kurban.goldmarket.common.Resource
import com.kurban.goldmarket.data.remote.RemoteDataSource
import com.kurban.goldmarket.domain.model.Model
import com.kurban.goldmarket.domain.repository.Repository
import kotlinx.coroutines.flow.Flow


class RepositoryImp(private val remoteDataSource: RemoteDataSource) : Repository {

    override fun getGoldList(): Flow<Resource<List<Model>>> {
        return remoteDataSource.getGoldList()
    }
}