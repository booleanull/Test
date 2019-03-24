package com.boolenull.test.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.boolenull.test.data.PostProvider
import com.boolenull.test.model.Post
import com.boolenull.test.view.MainView

@InjectViewState
class MainPresenter: MvpPresenter<MainView>() {

    private val postProvider = PostProvider(this)

    fun sendPostRequest(post: Post) {
        postProvider.sendPostRequest(post)
    }

    fun sendGetRequest(id: Int) {
        postProvider.sendGetRequest(id)
    }

    fun sendPutRequest(post: Post) {
        postProvider.sendPutRequest(post)
    }

    fun getPostFromDatabase(id: Int) {
        postProvider.getPostFromDatabase(id)
    }

    override fun onDestroy() {
        super.onDestroy()
        postProvider.subscription?.dispose()
    }
}