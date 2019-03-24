package com.boolenull.test.data

import android.content.Context
import android.util.Log
import com.boolenull.test.MyApplication
import com.boolenull.test.R
import com.boolenull.test.data.database.PostDatabase
import com.boolenull.test.data.network.ApiService
import com.boolenull.test.model.Post
import com.boolenull.test.presenter.MainPresenter
import io.reactivex.Observable
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
    @Inject
    lateinit var postDatabase: PostDatabase

    var subscription: Disposable? = null

    init {
        MyApplication.applicationComponent.inject(this)
    }

    fun sendPostRequest(post: Post) {
        sendRequest(context.getString(R.string.post), apiService.sendPostRequest(post), ::successPostAndPut)
    }

    fun sendGetRequest(id: Int) {
        sendRequest(context.getString(R.string.get), apiService.sendGetRequest(id), ::successGet)
    }

    fun sendPutRequest(post: Post) {
        sendRequest(context.getString(R.string.put), apiService.sendPutRequest(post.id, post), ::successPostAndPut)
    }

    private fun sendRequest(title: String, single: Single<Post>, success: (title: String, post: Post) -> Unit) {
        subscription = single
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        {success(title, it)},
                        {presenter.viewState.showError()})
    }

    private fun successGet(title: String, post: Post) {
        presenter.viewState.showDialogMessage(title, post)

        Observable.fromCallable {
            postDatabase.postDao().insert(post)
            Log.d("Dsadas", post.toString())
        }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe()
    }

    private fun successPostAndPut(title: String, post: Post) {
        presenter.viewState.showDialogMessage(title, post)
    }

    fun getPostFromDatabase(id: Int) {
        subscription = postDatabase.postDao().getById(id.toLong())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    presenter.viewState.showDialogMessage(context.getString(R.string.database), it)
                }, {
                    presenter.viewState.showError()
                })
    }
}
