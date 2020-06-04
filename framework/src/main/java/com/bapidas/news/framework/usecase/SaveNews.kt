package com.bapidas.news.framework.usecase

import com.bapidas.news.framework.db.entity.NewsEntity
import com.bapidas.news.framework.db.repository.RoomNewsRepository

class SaveNews(private val repository: RoomNewsRepository) {
    suspend operator fun invoke(newsEntity: List<NewsEntity>) =
        repository.saveNews(newsEntity)
}