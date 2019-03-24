package com.boolenull.test.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(var context: Context) {

    @Provides
    fun getContextDagger(): Context {
        return context
    }
}