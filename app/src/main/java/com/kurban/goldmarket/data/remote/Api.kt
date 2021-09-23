package com.kurban.goldmarket.data.remote

import com.kurban.goldmarket.data.model.DataModel

interface Api {

    fun getList(): List<DataModel>
}