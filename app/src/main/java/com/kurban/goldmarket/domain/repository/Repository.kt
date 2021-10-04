package com.kurban.goldmarket.domain.repository

import com.kurban.goldmarket.common.Resource
import com.kurban.goldmarket.domain.model.Model
import kotlinx.coroutines.flow.Flow


interface Repository {

    fun getGoldList(): Flow<Resource<List<Model>>>
}