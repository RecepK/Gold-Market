package com.kurban.goldmarket.data.remote

import com.kurban.goldmarket.data.model.DataModel
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("/RecepK/a7b91e8a701443516e625220322fbc57/raw/c33e9e923990aa0ccc7fd4ac3ae5768b8517cadd/sample.json")
    suspend fun getList(): Response<List<DataModel>>
}