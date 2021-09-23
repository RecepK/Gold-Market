package com.kurban.goldmarket.data.model

import com.kurban.goldmarket.domain.model.Model


data class DataModel(
    val name: String,
    val buy: String,
    val sell: String,
    val time: String,
)

fun DataModel.toModel(): Model {
    return Model(
        name = name,
        buy = buy,
        sell = sell,
        time = time,
        serviceName = ""
    )
}