package com.bapidas.news.main

import com.bapidas.news.R
import com.bapidas.news.appcore.activity.BaseActivity
import com.bapidas.news.databinding.ActivityMainBinding
import com.bapidas.news.main.news.listing.NewsActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val layoutViewRes: Int = R.layout.activity_main

    override val viewModelClass: Class<MainViewModel> = MainViewModel::class.java

    override fun onViewCreated() {
        super.onViewCreated()
        NewsActivity.openClear(this)
    }
}