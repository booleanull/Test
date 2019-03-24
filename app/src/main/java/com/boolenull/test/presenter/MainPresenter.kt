package com.boolenull.test.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.boolenull.test.data.PostProvider
import com.boolenull.test.model.Post
import com.boolenull.test.view.MainView

@InjectViewState
class MainPresenter: MvpPresenter<MainView>() {

    private val postProvider = PostProvider(this)

    var progress = false

    fun sendPost(post: Post) {
        progress = true
        postProvider.sendPost(post)
    }

    fun getPost(id: Int) {
        progress = true
        postProvider.getPost(id)
    }

    fun putPost(post: Post) {
        progress = true
        postProvider.putPost(post)
    }

    fun getFromDatabase(id: Int) {
        progress = true
        postProvider.getFromDatabase(id)
    }

    fun openSecondFragment() {
        viewState.showSecondFragment()
    }

    fun closeSecondFragment() {
        viewState.hideSecondFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        postProvider.subscription?.dispose()
    }
}