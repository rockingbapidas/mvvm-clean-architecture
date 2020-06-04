package com.bapidas.news.framework.db.repository

import com.bapidas.news.data.repository.NewsLocalRepository
import com.bapidas.news.framework.db.entity.NewsEntity
import com.bapidas.news.framework.db.source.IRoomNewsDataSource

class RoomNewsRepository(private val dataSource: IRoomNewsDataSource) :
    NewsLocalRepository(dataSource) {

    suspend fun saveNews(newsEntity: List<NewsEntity>) = dataSource.saveNews(newsEntity)

    suspend fun getNewsCount() = dataSource.getNewsCount()

    fun getNews() = dataSource.getNews()
}