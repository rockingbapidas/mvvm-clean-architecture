package com.bapidas.news.framework.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsEntity(
    @PrimaryKey
    @ColumnInfo(name = "publish_at")
    val publishedAt: String,
    @ColumnInfo(name = "title")
    val title: String? = null,
    @ColumnInfo(name = "description")
    val description: String? = null,
    @ColumnInfo(name = "url_to_image")
    val urlToImage: String? = null,
    @ColumnInfo(name = "source_name")
    val sourceName: String? = null
)