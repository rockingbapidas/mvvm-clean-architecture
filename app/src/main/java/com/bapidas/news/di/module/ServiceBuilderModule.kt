package com.bapidas.news.di.module

import com.bapidas.news.service.DemoService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ServiceBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeDemoService(): DemoService
}