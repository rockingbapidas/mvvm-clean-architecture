package com.bapidas.news.framework.db.source

import androidx.paging.DataSource
import com.bapidas.news.framework.db.dao.RoomNewsDao
import com.bapidas.news.framework.db.entity.NewsEntity

class RoomNewsDataSource(private val roomNewsDao: RoomNewsDao) :
    IRoomNewsDataSource {
    override suspend fun saveNews(news: List<NewsEntity>) {
        roomNewsDao.insert(news)
    }

    override fun getNews(): DataSource.Factory<Int, NewsEntity> {
        return roomNewsDao.getNewsList()
    }

    override suspend fun getNewsCount(): Int {
        return roomNewsDao.getNewsCount()
    }
}