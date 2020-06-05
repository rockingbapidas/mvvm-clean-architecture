package com.bapidas.news.main

import com.bapidas.news.appcore.di.scope.ActivityScope
import com.bapidas.news.appcore.viewmodel.BaseViewModel
import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor() : BaseViewModel()