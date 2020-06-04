package com.bapidas.news.main.news.listing.paging

import androidx.paging.ItemKeyedDataSource
import com.bapidas.news.framework.db.entity.NewsEntity
import com.bapidas.news.framework.interactions.NewsInteractions
import com.bapidas.news.framework.network.source.RemoteNewsDataSource.Companion.INITIAL_PAGE
import com.bapidas.news.framework.network.source.RemoteNewsDataSource.Companion.PAGE_SIZE
import com.bapidas.news.model.Article
import com.bapidas.news.model.mapToArticle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class NewsDataSource(
    private val mNewsInteractions: NewsInteractions,
    private val mCoroutineScope: CoroutineScope
) : ItemKeyedDataSource<String, Article>() {
    private var totalNewsArticle = 0
    private var loadedNewsArticle = 0

    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<Article>
    ) {
        Timber.v("loadInitial ")
        mCoroutineScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    mNewsInteractions.getRemoteNews(INITIAL_PAGE)
                }
                callback.onResult(mapResults(result.first, result.second))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<Article>) {
        Timber.v("loadAfter ")
        val isItemPending = loadedNewsArticle < totalNewsArticle
        val nextPage = loadedNewsArticle.div(PAGE_SIZE).plus(1)
        if (isItemPending) {
            mCoroutineScope.launch {
                try {
                    val result = withContext(Dispatchers.IO) {
                        mNewsInteractions.getRemoteNews(nextPage)
                    }
                    callback.onResult(mapResults(result.first, result.second))
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<Article>) {
        Timber.v("loadBefore ")
    }

    override fun getKey(item: Article): String {
        Timber.v("getKey %s ", item.toString())
        return item.publishedAt
    }

    private fun mapResults(
        totalResults: Int,
        newsList: List<NewsEntity>
    ): List<Article> {
        Timber.v("mapResults ")
        loadedNewsArticle += PAGE_SIZE
        totalNewsArticle = totalResults
        return newsList.mapToArticle()
    }
}