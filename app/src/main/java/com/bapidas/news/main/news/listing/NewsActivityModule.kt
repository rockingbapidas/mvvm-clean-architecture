package com.bapidas.news.main.news.listing

import androidx.appcompat.app.AppCompatActivity
import com.bapidas.news.appcore.activity.BaseActivityModule
import com.bapidas.news.appcore.di.key.ActivityViewModelKey
import com.bapidas.news.appcore.di.scope.ActivityScope
import com.bapidas.news.appcore.viewmodel.BaseViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [BaseActivityModule::class])
abstract class NewsActivityModule {
    @Binds
    @ActivityScope
    abstract fun bindActivity(activity: NewsActivity): AppCompatActivity

    @Binds
    @IntoMap
    @ActivityViewModelKey(NewsViewModel::class)
    @ActivityScope
    abstract fun bindViewModel(viewModel: NewsViewModel): BaseViewModel
}