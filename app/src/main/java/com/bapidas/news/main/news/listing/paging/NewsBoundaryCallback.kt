package com.bapidas.news.main.news.listing.paging

import androidx.paging.PagedList
import com.bapidas.news.framework.db.entity.NewsEntity
import com.bapidas.news.framework.interactions.NewsInteractions
import com.bapidas.news.framework.network.source.RemoteNewsDataSource.Companion.INITIAL_PAGE
import com.bapidas.news.framework.network.source.RemoteNewsDataSource.Companion.PAGE_SIZE
import com.bapidas.news.model.Article
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class NewsBoundaryCallback(
    private val mNewsInteractions: NewsInteractions,
    private val mCoroutineScope: CoroutineScope
) : PagedList.BoundaryCallback<Article>() {
    private var latestLoad = true
    private var totalNewsArticle = 0
    private var loadedNewsArticle = 0

    override fun onZeroItemsLoaded() {
        super.onZeroItemsLoaded()
        Timber.v("onZeroItemsLoaded")
        latestLoad = false
        loadNewsArticles(INITIAL_PAGE, latestLoad)
    }

    override fun onItemAtFrontLoaded(itemAtFront: Article) {
        super.onItemAtFrontLoaded(itemAtFront)
        Timber.v("onItemAtFrontLoaded")
        if (latestLoad) {
            loadNewsArticles(INITIAL_PAGE, latestLoad)
            latestLoad = false
        }
    }

    override fun onItemAtEndLoaded(itemAtEnd: Article) {
        super.onItemAtEndLoaded(itemAtEnd)
        Timber.v("onItemAtEndLoaded")
        loadMoreNewsArticles()
    }

    private fun loadMoreNewsArticles() {
        Timber.v("loadMoreNewsArticles ")
        val isItemPending = loadedNewsArticle < totalNewsArticle
        val nextPage = loadedNewsArticle.div(PAGE_SIZE).plus(1)
        if (isItemPending) loadNewsArticles(nextPage, latestLoad)
    }

    private fun loadNewsArticles(nextPage: Int, latestLoad: Boolean) {
        mCoroutineScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    mNewsInteractions.getRemoteNews(nextPage)
                }
                cacheInLocal(latestLoad, result.first, result.second)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private suspend fun cacheInLocal(
        latestLoad: Boolean,
        totalResults: Int,
        newsList: List<NewsEntity>
    ) {
        Timber.v("cacheInLocal ")
        if (latestLoad)
            loadedNewsArticle = mNewsInteractions.getNewsCount()
        else
            loadedNewsArticle += PAGE_SIZE
        totalNewsArticle = totalResults
        mNewsInteractions.saveNews(newsList)
    }
}