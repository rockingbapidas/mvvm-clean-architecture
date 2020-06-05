package com.bapidas.news.headlines.model

import com.bapidas.news.framework.db.entity.NewsEntity

fun NewsEntity.mapToArticle(): Article {
    return Article(
        publishedAt = publishedAt,
        title = title,
        description = description,
        urlToImage = urlToImage,
        sourceName = sourceName
    )
}

fun List<NewsEntity>.mapToArticle(): List<Article> {
    return map {
        it.mapToArticle()
    }
}