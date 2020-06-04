package com.bapidas.news.main.news.listing.paging

import androidx.paging.DataSource
import com.bapidas.news.framework.interactions.NewsInteractions
import com.bapidas.news.model.Article
import kotlinx.coroutines.CoroutineScope
import timber.log.Timber

class NewsDataSourceFactory(
    private val mNewsInteractions: NewsInteractions,
    private val mCoroutineScope: CoroutineScope
) : DataSource.Factory<String, Article>() {

    override fun create(): DataSource<String, Article> {
        Timber.v("create")
        return NewsDataSource(mNewsInteractions, mCoroutineScope)
    }
}