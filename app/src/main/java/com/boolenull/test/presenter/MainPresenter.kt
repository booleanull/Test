package com.boolenull.test.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.boolenull.test.view.MainView

@InjectViewState
class MainPresenter: MvpPresenter<MainView>() {

    fun openSecondFragment() {
        viewState.showSecondFragment()
    }

    fun closeSecondFragment() {
        viewState.hideSecondFragment()
    }
}