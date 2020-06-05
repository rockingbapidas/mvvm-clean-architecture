package com.bapidas.news.di.module

import android.app.Application
import android.content.Context
import com.bapidas.news.NewsApplication
import com.bapidas.news.appcore.di.qualifier.ApplicationContext
import com.bapidas.news.framework.di.module.*
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjectionModule

@Module(
    includes = [
        AndroidInjectionModule::class,
        ActivityBuilderModule::class,
        ServiceBuilderModule::class,
        ReceiverBuilderModule::class,
        WorkerBuilderModule::class,
        TimberModule::class,
        NetworkModule::class,
        RoomModule::class,
        ApiModule::class,
        InteractionsModule::class
    ]
)
abstract class ApplicationModule {
    @Binds
    abstract fun bindApplication(application: NewsApplication): Application

    @Binds
    @ApplicationContext
    abstract fun bindApplicationContext(application: Application): Context
}
