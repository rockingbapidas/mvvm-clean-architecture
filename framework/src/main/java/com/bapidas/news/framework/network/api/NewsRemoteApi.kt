package com.bapidas.news.framework.network.api

import com.bapidas.news.domain.NewsList
import com.bapidas.news.framework.network.Urls
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsRemoteApi {
    @GET(Urls.News.ARTICLES_API)
    suspend fun fetchNewsFromServer(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
        @Query("q") category: String,
        @Query("apiKey") apiKey: String
    ): NewsList
}