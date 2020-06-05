package com.bapidas.news.headlines.di.module

import com.bapidas.news.headlines.service.HeadlinesDemoService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class HeadlinesServiceModule {
    @ContributesAndroidInjector
    abstract fun contributeHeadlinesDemoService(): HeadlinesDemoService
}