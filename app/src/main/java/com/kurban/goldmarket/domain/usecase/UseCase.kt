package com.kurban.goldmarket.domain.usecase

import com.kurban.goldmarket.domain.repository.Repository


class UseCase(private val repository: Repository) {

    fun getGoldList() = repository.getGoldList()
}