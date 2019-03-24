package com.boolenull.test

import android.app.Application
import com.boolenull.test.di.*

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .networkModule(NetworkModule())
                .databaseModule(DatabaseModule())
                .build()
    }

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }
}