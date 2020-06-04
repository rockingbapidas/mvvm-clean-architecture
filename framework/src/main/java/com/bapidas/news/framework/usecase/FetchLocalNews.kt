package com.bapidas.news.framework.usecase

import com.bapidas.news.framework.db.repository.RoomNewsRepository

class FetchLocalNews(private val repository: RoomNewsRepository) {
    operator fun invoke() = repository.getNews()
}