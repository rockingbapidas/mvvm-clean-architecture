package com.bapidas.news.framework.usecase

import com.bapidas.news.framework.db.repository.RoomNewsRepository

class FetchNewsCount(private val repository: RoomNewsRepository) {
    suspend operator fun invoke() = repository.getNewsCount()
}