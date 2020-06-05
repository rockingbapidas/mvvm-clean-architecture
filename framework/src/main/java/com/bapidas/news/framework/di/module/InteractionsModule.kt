package com.bapidas.news.framework.di.module

import com.bapidas.news.framework.db.dao.RoomNewsDao
import com.bapidas.news.framework.db.repository.RoomNewsRepository
import com.bapidas.news.framework.db.source.RoomNewsDataSource
import com.bapidas.news.framework.interactions.NewsInteractions
import com.bapidas.news.framework.network.api.NewsRemoteApi
import com.bapidas.news.framework.network.repository.RemoteNewsRepository
import com.bapidas.news.framework.network.source.RemoteNewsDataSource
import com.bapidas.news.framework.usecase.FetchNews
import com.bapidas.news.framework.usecase.FetchNewsCount
import com.bapidas.news.framework.usecase.FetchRemoteNews
import com.bapidas.news.framework.usecase.SaveNews
import com.bapidas.news.usecase.GetNews
import dagger.Module
import dagger.Provides

@Module
class InteractionsModule {
    @Provides
    fun provideNewsInteractions(
        newsRemoteApi: NewsRemoteApi,
        newsDao: RoomNewsDao
    ): NewsInteractions {
        val localRepository = RoomNewsRepository(RoomNewsDataSource(newsDao))
        val remoteRepository = RemoteNewsRepository(RemoteNewsDataSource(newsRemoteApi))
        return NewsInteractions(
            SaveNews(localRepository),
            FetchNews(localRepository),
            FetchNewsCount(localRepository),
            FetchRemoteNews(GetNews(remoteRepository))
        )
    }
}