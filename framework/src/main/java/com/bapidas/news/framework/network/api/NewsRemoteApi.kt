package com.bapidas.news.framework.network.api

import com.bapidas.news.domain.NewsList
import com.bapidas.news.framework.network.Urls
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsRemoteApi {
    @GET(Urls.News.ARTICLES_API)
    suspend fun fetchNewsFromServer(
        @Query("q") category: String,
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String
    ): NewsList
}