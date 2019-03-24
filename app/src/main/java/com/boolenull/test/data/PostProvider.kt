package com.boolenull.test.data

import android.content.Context
import com.boolenull.test.MyApplication
import com.boolenull.test.R
import com.boolenull.test.model.Post
import com.boolenull.test.presenter.MainPresenter
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostProvider(val presenter: MainPresenter) {

    @Inject
    lateinit var context: Context
    @Inject
    lateinit var apiService: ApiService

    var subscription: Disposable? = null

    init {
        MyApplication.applicationComponent.inject(this)
    }

    fun sendPostRequest(post: Post) {
        sendRequest(context.getString(R.string.post), apiService.sendPostRequest(post))
    }

    fun sendGetRequest(id: Int) {
        sendRequest(context.getString(R.string.get), apiService.sendGetRequest(id))
    }

    fun sendPutRequest(post: Post) {
        sendRequest(context.getString(R.string.put), apiService.sendPutRequest(post.id, post))
    }

    private fun sendRequest(title: String, single: Single<Post>) {
        subscription = single
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        {presenter.viewState.showDialogMessage(title, it)},
                        {presenter.viewState.showError()})
    }

    fun getPostFromDatabase(id: Int) {

    }
}