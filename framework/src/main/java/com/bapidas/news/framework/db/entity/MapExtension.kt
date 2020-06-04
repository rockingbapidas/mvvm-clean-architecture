package com.bapidas.news.framework.db.entity

import com.bapidas.news.domain.News

fun News.mapToNewsEntity(): NewsEntity {
    return NewsEntity(
        publishedAt = publishedAt,
        title = title,
        description = description,
        urlToImage = urlToImage,
        sourceName = source?.name
    )
}

fun List<News>.mapToNewsEntity(): List<NewsEntity> {
    return map {
        it.mapToNewsEntity()
    }
}