package com.bapidas.news.framework.network.repository

import com.bapidas.news.data.repository.NewsRemoteRepository
import com.bapidas.news.data.source.NewsRemoteDataSource
import com.bapidas.news.framework.network.entity.mapToNewsListEntity

class RemoteNewsRepository(dataSource: NewsRemoteDataSource) : NewsRemoteRepository(dataSource) {
    suspend fun requestNews(page: Int) = getRemoteNews(page).mapToNewsListEntity()
}