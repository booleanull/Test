package com.boolenull.test.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.boolenull.test.model.Post

@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class PostDatabase(): RoomDatabase() {
    abstract fun postDao(): PostDao
}