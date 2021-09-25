package com.kurban.goldmarket.domain.model


data class Model(
    val name: String,
    val buy: String,
    val sell: String,
    val time: String,
    val serviceName: String
) {
    override fun toString(): String {
        return "name='$name' \nbuy='$buy' \nsell='$sell' \ntime='$time' \nserviceName='$serviceName'"
    }
}