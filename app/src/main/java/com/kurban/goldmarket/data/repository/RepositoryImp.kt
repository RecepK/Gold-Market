package com.kurban.goldmarket.data.repository

import com.kurban.goldmarket.data.model.toModel
import com.kurban.goldmarket.data.remote.Client
import com.kurban.goldmarket.domain.model.Model
import com.kurban.goldmarket.domain.repository.Repository


class RepositoryImp(private val client: Client) : Repository {

    override fun getGoldList(): List<Model> {
        return client.getList().map { it.toModel() }
    }
}