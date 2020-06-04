package com.bapidas.news.framework.usecase

import com.bapidas.news.framework.db.entity.NewsEntity
import com.bapidas.news.framework.db.entity.mapToNewsEntity
import com.bapidas.news.usecase.GetNews

class FetchRemoteNews(private val getNews: GetNews) {
    suspend operator fun invoke(page: Int): Pair<Int, List<NewsEntity>> {
        val result = getNews(page)
        return Pair(result.totalResults, result.articles.mapToNewsEntity())
    }
}