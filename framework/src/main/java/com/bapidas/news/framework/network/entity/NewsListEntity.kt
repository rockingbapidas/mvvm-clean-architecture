package com.bapidas.news.framework.network.entity

import com.bapidas.news.domain.News
import com.google.gson.annotations.SerializedName

data class NewsListEntity(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int,
    @SerializedName("articles")
    val articles: List<News>
)