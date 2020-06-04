package com.bapidas.news.data.source

import com.bapidas.news.domain.NewsList

interface NewsRemoteDataSource {
    suspend fun getRemoteNews(page: Int): NewsList
}