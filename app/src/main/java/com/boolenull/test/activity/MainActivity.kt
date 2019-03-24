package com.boolenull.test.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.boolenull.test.R
import com.boolenull.test.fragment.FirstFragment
import com.boolenull.test.fragment.SecondFragment
import com.boolenull.test.model.Post
import com.boolenull.test.presenter.MainPresenter
import com.boolenull.test.view.MainView

class MainActivity: MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    private var firstFragment = FirstFragment()
    private val secondFragment = SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        removeAllFragments()
        addNewFragment(R.id.contentFragmentFirst, firstFragment)
    }

    private fun removeAllFragments() {
        supportFragmentManager.fragments.forEach {
            deleteFragment(it)
        }
    }

    private fun addNewFragment(contentId: Int, fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(contentId, fragment)
                .commit()
    }

    private fun deleteFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .remove(fragment)
                .commit()
    }

    override fun showDialogMessage(title: String, post: Post) {
        Toast.makeText(this, "${title} + ${post.toString()}", Toast.LENGTH_SHORT).show()
    }

    override fun hideDialogMessage() {
    }

    override fun showSecondFragment() {
        addNewFragment(R.id.contentFragmentSecond, secondFragment)
        firstFragment.disableSecondFragmentButton()
    }

    override fun hideSecondFragment() {
        deleteFragment(secondFragment)
        firstFragment.enableSecondFragmentButton()
    }

    override fun showError() {
        Toast
                .makeText(this, getString(R.string.error), Toast.LENGTH_SHORT)
                .show()
    }
}
