package com.bapidas.news.base.viewmodel

import android.content.Intent
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    open fun handleCreate() {}

    open fun handleIntent(intent: Intent) {}

    open fun handleResult(requestCode: Int, resultCode: Int, data: Intent?) {}

    open fun handlePermissionResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
    }

    @CallSuper
    open fun handleRestoreInstanceState(savedInstanceState: Bundle) {
    }

    open fun handleReady() {}

    open fun handlePause() {}

    @CallSuper
    open fun handleSaveInstanceState(outState: Bundle) {

    }
}