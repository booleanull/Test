package com.boolenull.test.di

import android.arch.persistence.room.Room
import android.content.Context
import com.boolenull.test.data.database.PostDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun getDatabase(context: Context): PostDatabase {
        return Room.databaseBuilder(context, PostDatabase::class.java, "post")
                .build()
    }
}