package com.boolenull.test.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.boolenull.test.R
import com.boolenull.test.activity.MainActivity
import com.boolenull.test.model.Post
import kotlinx.android.synthetic.main.fragment_second.view.*

class SecondFragment: Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        view.putButton.setOnClickListener(this)
        view.databaseButton.setOnClickListener(this)
        view.closeButton.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        if (!(activity as MainActivity).mainPresenter.progress) {
            when (v?.id) {
                R.id.putButton -> {
                    (activity as MainActivity).mainPresenter.putPost(Post(1, 1, "Title", "Body"))
                }
                R.id.databaseButton -> {
                    (activity as MainActivity).mainPresenter.getFromDatabase(1)
                }
                R.id.closeButton -> {
                    (activity as MainActivity).mainPresenter.closeSecondFragment()
                }
            }
        }
    }
}
