package com.bapidas.news.main.news.listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.bapidas.news.BuildConfig
import com.bapidas.news.appcore.di.scope.ActivityScope
import com.bapidas.news.appcore.viewmodel.BaseViewModel
import com.bapidas.news.framework.interactions.NewsInteractions
import com.bapidas.news.framework.network.source.RemoteNewsDataSource.Companion.PAGE_SIZE
import com.bapidas.news.main.news.listing.paging.NewsBoundaryCallback
import com.bapidas.news.main.news.listing.paging.NewsDataSourceFactory
import com.bapidas.news.model.Article
import com.bapidas.news.model.mapToArticle
import javax.inject.Inject

@ActivityScope
class NewsViewModel @Inject constructor(
    private val mNewsInteractions: NewsInteractions
) : BaseViewModel() {

    //Progress live data
    val isLoading = MutableLiveData(true)

    //Live data Paged List
    val newsArticles by lazy {
        buildLiveDataList()
    }

    private fun buildLiveDataList(): LiveData<PagedList<Article>> {
        val mPagedListConfig by lazy {
            PagedList.Config.Builder()
                .setPageSize(PAGE_SIZE)
                .setEnablePlaceholders(false)
                .setPrefetchDistance(5)
                .build()
        }
        return if (BuildConfig.LOCAL_CACHE) {
            val factory = mNewsInteractions.getNews().map { it.mapToArticle() }
            LivePagedListBuilder(factory, mPagedListConfig)
                .setBoundaryCallback(NewsBoundaryCallback(mNewsInteractions, viewModelScope))
                .build()
        } else {
            LivePagedListBuilder(
                NewsDataSourceFactory(mNewsInteractions, viewModelScope),
                mPagedListConfig
            ).build()
        }
    }
}