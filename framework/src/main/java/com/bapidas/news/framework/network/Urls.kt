package com.bapidas.news.framework.network

import com.bapidas.news.framework.BuildConfig

object Urls {
    var BASE_URL = BuildConfig.API_DOMAIN

    object News {
        const val ARTICLES_API = "/v2/everything"
    }
}