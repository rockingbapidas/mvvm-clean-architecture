package com.bapidas.news.data.repository

import com.bapidas.news.data.source.NewsLocalDataSource

abstract class NewsLocalRepository(private val dataSource: NewsLocalDataSource)