package com.bapidas.news.framework.network.source

import com.bapidas.news.framework.BuildConfig
import com.bapidas.news.framework.network.api.NewsRemoteApi

class RemoteNewsDataSource(private val newsRemoteApi: NewsRemoteApi) : IRemoteNewsDataSource {

    override suspend fun getRemoteNews(page: Int) =
        newsRemoteApi.fetchNewsFromServer(
            page,
            PAGE_SIZE,
            CATEGORY,
            BuildConfig.API_KEY
        )

    companion object {
        const val INITIAL_PAGE = 1
        const val PAGE_SIZE = 20
        const val CATEGORY = "business"
    }
}