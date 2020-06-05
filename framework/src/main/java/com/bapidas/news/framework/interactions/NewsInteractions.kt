package com.bapidas.news.framework.interactions

import com.bapidas.news.framework.usecase.FetchNews
import com.bapidas.news.framework.usecase.FetchNewsCount
import com.bapidas.news.framework.usecase.FetchRemoteNews
import com.bapidas.news.framework.usecase.SaveNews

data class NewsInteractions(
    val saveNews: SaveNews,
    val getNews: FetchNews,
    val getNewsCount: FetchNewsCount,
    val getRemoteNews: FetchRemoteNews
)