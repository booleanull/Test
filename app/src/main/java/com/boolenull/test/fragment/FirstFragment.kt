package com.boolenull.test.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.boolenull.test.R
import com.boolenull.test.activity.MainActivity
import com.boolenull.test.view.FirstFragmentView
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment: Fragment(), FirstFragmentView, View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        view.postButton.setOnClickListener(this)
        view.getButton.setOnClickListener(this)
        view.openButton.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.postButton -> {

            }
            R.id.getButton -> {

            }
            R.id.openButton -> {
                (activity as MainActivity).mainPresenter.openSecondFragment()
            }
        }
    }

    override fun enableSecondFragmentButton() {
        openButton.isEnabled = true
    }

    override fun disableSecondFragmentButton() {
        openButton.isEnabled = false
    }
}
