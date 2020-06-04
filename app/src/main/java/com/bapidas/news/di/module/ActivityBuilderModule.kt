package com.bapidas.news.di.module

import com.bapidas.news.framework.di.scope.ActivityScope
import com.bapidas.news.main.MainActivity
import com.bapidas.news.main.MainActivityModule
import com.bapidas.news.main.news.detail.NewsDetailActivityModule
import com.bapidas.news.main.news.detail.NewsDetailsActivity
import com.bapidas.news.main.news.listing.NewsActivity
import com.bapidas.news.main.news.listing.NewsActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    @ActivityScope
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [NewsActivityModule::class])
    @ActivityScope
    abstract fun contributeNewsActivity(): NewsActivity

    @ContributesAndroidInjector(modules = [NewsDetailActivityModule::class])
    @ActivityScope
    abstract fun contributeNewsDetailsActivity(): NewsDetailsActivity
}
