package com.bapidas.news.framework.network.source

import com.bapidas.news.data.source.NewsRemoteDataSource
import com.bapidas.news.framework.BuildConfig
import com.bapidas.news.framework.network.api.NewsRemoteApi

class RemoteNewsDataSource(private val newsRemoteApi: NewsRemoteApi) : NewsRemoteDataSource {
    override suspend fun getRemoteNews(page: Int) =
        newsRemoteApi.fetchNewsFromServer(
            CATEGORY,
            PAGE_SIZE, page,
            BuildConfig.API_KEY
        )

    companion object {
        const val INITIAL_PAGE = 1
        const val PAGE_SIZE = 20
        const val CATEGORY = "business"
    }
}