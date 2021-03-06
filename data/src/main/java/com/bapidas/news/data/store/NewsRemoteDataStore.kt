package com.bapidas.news.data.store

import com.bapidas.news.data.model.NewsListEntity
import com.bapidas.news.data.repository.NewsRemoteRepository

class NewsRemoteDataStore constructor(private val mNewsRemoteRepository: NewsRemoteRepository) :
    NewsDataStore {
    override suspend fun getNews(requestedLoadSize: Int): NewsListEntity {
        return mNewsRemoteRepository.getNews(requestedLoadSize = requestedLoadSize)
    }

    override suspend fun getNewsAfter(
        requestedLoadSize: Int,
        page: Int,
        key: String
    ): NewsListEntity {
        return mNewsRemoteRepository.getNewsAfter(
            requestedLoadSize = requestedLoadSize,
            page = page
        )
    }

    override suspend fun getNewsCount(): Int {
        throw UnsupportedOperationException()
    }

    override suspend fun saveNews(newsListEntity: NewsListEntity) {
        throw UnsupportedOperationException()
    }

    override suspend fun clearNews() {
        throw UnsupportedOperationException()
    }
}