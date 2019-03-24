package com.boolenull.test.di

import com.boolenull.test.data.PostProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {
    fun inject(postProvider: PostProvider)
}