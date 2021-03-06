package com.bapidas.news.domain

import com.bapidas.news.domain.model.NewsListDomain

interface NewsRepository {
    suspend fun getNews(local: Boolean, requestedLoadSize: Int): NewsListDomain

    suspend fun getNewsAfter(
        local: Boolean,
        requestedLoadSize: Int,
        page: Int,
        key: String
    ): NewsListDomain

    suspend fun getNewsCount(): Int

    suspend fun saveNews(news: NewsListDomain)

    suspend fun clearNews()
}