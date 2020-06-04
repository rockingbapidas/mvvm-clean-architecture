package com.bapidas.news.main.news.listing.adapter

import androidx.recyclerview.widget.DiffUtil
import com.bapidas.news.R
import com.bapidas.news.base.adapter.callback.ItemViewListener
import com.bapidas.news.base.adapter.recycler.BasePagedListAdapter
import com.bapidas.news.model.Article

class NewsAdapter(private val callback: ItemViewListener) :
    BasePagedListAdapter<Article>(NEWS_COMPARATOR) {

    override fun getCallbackForPosition(position: Int): Any = callback

    override fun getLayoutIdForPosition(position: Int): Int = R.layout.item_news

    companion object {
        val NEWS_COMPARATOR = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(
                oldItem: Article,
                newItem: Article
            ): Boolean {
                return oldItem.publishedAt == newItem.publishedAt
            }

            override fun areContentsTheSame(
                oldItem: Article,
                newItem: Article
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}