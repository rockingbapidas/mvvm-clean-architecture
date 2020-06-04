package com.bapidas.news.framework.network.repository

import com.bapidas.news.data.repository.NewsRemoteRepository
import com.bapidas.news.data.source.NewsRemoteDataSource

class RemoteNewsRepository(dataSource: NewsRemoteDataSource) : NewsRemoteRepository(dataSource)