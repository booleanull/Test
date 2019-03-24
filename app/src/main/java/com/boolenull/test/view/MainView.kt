package com.boolenull.test.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.boolenull.test.model.Post

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView: MvpView {

    fun showDialogMessage(title: String, post: Post)

    fun hideDialogMessage()

    fun showSecondFragment()

    fun hideSecondFragment()

    @StateStrategyType(SkipStrategy::class)
    fun showError()
}