package com.bapidas.news.main.news.detail

import androidx.appcompat.app.AppCompatActivity
import com.bapidas.news.base.activity.BaseActivityModule
import com.bapidas.news.base.viewmodel.BaseViewModel
import com.bapidas.news.di.key.ActivityViewModelKey
import com.bapidas.news.framework.di.scope.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [BaseActivityModule::class])
abstract class NewsDetailActivityModule {
    @Binds
    @ActivityScope
    abstract fun bindActivity(activity: NewsDetailsActivity): AppCompatActivity

    @Binds
    @IntoMap
    @ActivityViewModelKey(NewsDetailViewModel::class)
    @ActivityScope
    abstract fun bindViewModel(viewModel: NewsDetailViewModel): BaseViewModel
}