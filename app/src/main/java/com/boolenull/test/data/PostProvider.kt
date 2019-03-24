package com.boolenull.test.data

import android.content.Context
import com.boolenull.test.MyApplication
import com.boolenull.test.R
import com.boolenull.test.model.Post
import com.boolenull.test.presenter.MainPresenter
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

    fun sendPost(post: Post) {
        subscription = apiService.sendPost(post)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doAfterTerminate {presenter.progress = false}
                .subscribe(
                        {presenter.viewState.showDialogMessage(context.getString(R.string.post), it)},
                        {presenter.viewState.showError()})
    }

    fun getPost(id: Int) {
        subscription = apiService.getPost(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doAfterTerminate {presenter.progress = false}
                .subscribe(
                        {presenter.viewState.showDialogMessage(context.getString(R.string.get), it)},
                        {presenter.viewState.showError()})
    }

    fun putPost(post: Post) {
        subscription = apiService.putPost(post.id, post)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doAfterTerminate {presenter.progress = false}
                .subscribe(
                        {presenter.viewState.showDialogMessage(context.getString(R.string.put), it)},
                        {presenter.viewState.showError()})
    }

    fun getFromDatabase(id: Int) {

    }
}