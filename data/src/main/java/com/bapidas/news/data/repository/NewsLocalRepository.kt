package com.bapidas.news.data.repository

import com.bapidas.news.data.model.NewsListEntity

interface NewsLocalRepository {
    suspend fun getNews(requestedLoadSize: Int): NewsListEntity

    suspend fun getNewsAfter(requestedLoadSize: Int, key: String): NewsListEntity

    suspend fun getNewsCount(): Int

    suspend fun saveNews(newsListEntity: NewsListEntity)

    suspend fun clearNews()
}