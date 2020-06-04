package com.bapidas.news.usecase

import com.bapidas.news.data.repository.NewsRemoteRepository

class GetNews(private val repository: NewsRemoteRepository) {
    suspend operator fun invoke(page: Int) = repository.getRemoteNews(page = page)
}