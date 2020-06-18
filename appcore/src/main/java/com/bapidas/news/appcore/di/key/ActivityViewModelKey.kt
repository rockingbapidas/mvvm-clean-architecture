package com.bapidas.news.appcore.di.key

import com.bapidas.news.appcore.viewmodel.BaseViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
@MustBeDocumented
annotation class ActivityViewModelKey(val value: KClass<out BaseViewModel>)