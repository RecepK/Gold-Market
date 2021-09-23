package com.kurban.goldmarket.data.remote

import com.kurban.goldmarket.data.model.DataModel
import org.jsoup.Connection


class Client(private val connection: Connection) : Api {

    override fun getList(): List<DataModel> = ArrayList<DataModel>().apply {
        val elementsClass = getDocument().getElementsByClass("tableBox")

        val items = elementsClass[0].getElementsByTag("ul")
        for (index in items.indices) {
            val element = items[index].getElementsByTag("li")

            add(
                DataModel(
                    name = element[0].text(),
                    buy = element[1].text(),
                    sell = element[2].text(),
                    time = element[4].text()
                )
            )
        }

        //
        removeAt(0)
    }

    private fun getDocument() = connection.get()
}