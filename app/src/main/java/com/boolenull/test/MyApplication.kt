package com.boolenull.test

import android.app.Application
import com.boolenull.test.di.ApplicationComponent
import com.boolenull.test.di.ApplicationModule
import com.boolenull.test.di.DaggerApplicationComponent
import com.boolenull.test.di.NetworkModule

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .networkModule(NetworkModule())
                .build()
    }

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }
}