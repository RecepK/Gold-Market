package com.kurban.goldmarket.domain.repository

import com.kurban.goldmarket.domain.model.Model


interface Repository {

    fun getGoldList(): List<Model>
}