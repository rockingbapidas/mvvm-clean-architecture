package com.bapidas.news.domain

import com.google.gson.annotations.SerializedName

data class NewsList(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int,
    @SerializedName("articles")
    val articles: List<News>
)