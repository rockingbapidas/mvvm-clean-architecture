package com.bapidas.news.base.viewmodel.factory

import androidx.lifecycle.ViewModel
import com.bapidas.news.base.viewmodel.BaseViewModel
import com.bapidas.news.framework.di.scope.ActivityScope
import javax.inject.Inject
import javax.inject.Provider

@ActivityScope
class ActivityViewModelFactory @Inject constructor(
    creators: Map<Class<out BaseViewModel>,
            @JvmSuppressWildcards Provider<BaseViewModel>>
) : BaseViewModelFactory(creators as Map<Class<out ViewModel>, Provider<ViewModel>>)