package com.bapidas.news.framework.usecase

import com.bapidas.news.framework.db.entity.NewsEntity
import com.bapidas.news.framework.db.entity.mapToNewsEntity
import com.bapidas.news.framework.network.repository.RemoteNewsRepository

class RequestNews(private val repository: RemoteNewsRepository) {
    suspend operator fun invoke(page: Int): Pair<Int, List<NewsEntity>> {
        val result = repository.requestNews(page)
        return Pair(result.totalResults, result.articles.mapToNewsEntity())
    }
}