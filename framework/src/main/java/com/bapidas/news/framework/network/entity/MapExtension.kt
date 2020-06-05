package com.bapidas.news.framework.network.entity

import com.bapidas.news.domain.NewsList

fun NewsList.mapToNewsListEntity(): NewsListEntity {
    return NewsListEntity(status, totalResults, articles)
}