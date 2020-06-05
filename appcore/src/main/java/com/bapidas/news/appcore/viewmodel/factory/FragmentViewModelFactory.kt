package com.bapidas.news.appcore.viewmodel.factory

import androidx.lifecycle.ViewModel
import com.bapidas.news.appcore.di.scope.FragmentScope
import com.bapidas.news.appcore.viewmodel.BaseViewModel
import javax.inject.Inject
import javax.inject.Provider

@FragmentScope
class FragmentViewModelFactory @Inject constructor(
    creators: Map<Class<out BaseViewModel>,
            @JvmSuppressWildcards Provider<BaseViewModel>>
) :
    BaseViewModelFactory(creators as Map<Class<out ViewModel>, Provider<ViewModel>>)