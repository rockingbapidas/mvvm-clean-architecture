package com.bapidas.news.data.repository

import com.bapidas.news.data.source.NewsRemoteDataSource

abstract class NewsRemoteRepository(private val dataSource: NewsRemoteDataSource) {
    suspend fun getRemoteNews(page: Int) = dataSource.getRemoteNews(page = page)
}