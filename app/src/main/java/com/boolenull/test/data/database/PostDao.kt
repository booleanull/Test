package com.boolenull.test.data.database

import android.arch.persistence.room.*
import com.boolenull.test.model.Post
import io.reactivex.Single

@Dao
interface PostDao {

    @Query("SELECT * FROM post ORDER BY id")
    fun all(): List<Post>

    @Query("SELECT * FROM post WHERE id = :id")
    fun getById(id: Long): Single<Post?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(models: List<Post>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(model: Post)

    @Delete
    fun delete(repositoryModel: Post)

    @Query("DELETE FROM post")
    fun deleteAll()
}