package com.boolenull.test.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.boolenull.test.R
import com.boolenull.test.activity.MainActivity
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
        when (v?.id) {
            R.id.postButton -> {

            }
            R.id.getButton -> {

            }
            R.id.closeButton -> {
                (activity as MainActivity).mainPresenter.closeSecondFragment()
            }
        }
    }
}
