package com.bapidas.news.framework.db.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import com.bapidas.news.framework.db.entity.NewsEntity

@Dao
interface RoomNewsDao : RoomBaseDao<NewsEntity> {
    @Query("SELECT * FROM news")
    fun getNewsList(): DataSource.Factory<Int, NewsEntity>

    @Query("SELECT COUNT(publish_at) FROM news")
    suspend fun getNewsCount(): Int
}