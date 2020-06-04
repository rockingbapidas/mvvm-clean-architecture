package com.bapidas.news.framework.db.source

import androidx.paging.DataSource
import com.bapidas.news.data.source.NewsLocalDataSource
import com.bapidas.news.framework.db.entity.NewsEntity

interface IRoomNewsDataSource : NewsLocalDataSource {

    suspend fun saveNews(news: List<NewsEntity>)

    suspend fun getNewsCount(): Int

    fun getNews(): DataSource.Factory<Int, NewsEntity>
}