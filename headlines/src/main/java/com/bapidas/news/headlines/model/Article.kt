package com.bapidas.news.headlines.model

import java.io.Serializable

class Article(
    val publishedAt: String,
    val title: String? = null,
    val description: String? = null,
    val urlToImage: String? = null,
    val sourceName: String? = null,
    val url: String? = null
) : Serializable {
    val dateString
        get() = publishedAt.split("T").getOrElse(0) { "" }
}