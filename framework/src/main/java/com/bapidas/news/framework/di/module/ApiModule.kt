package com.bapidas.news.framework.di.module

import com.bapidas.news.framework.network.api.NewsRemoteApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    fun provideNewsRemoteApi(
        retrofit: Retrofit
    ): NewsRemoteApi = retrofit.create(NewsRemoteApi::class.java)
}