package com.boolenull.test.data

import com.boolenull.test.model.Post
import io.reactivex.Single
import retrofit2.http.*

interface ApiService {

    @POST("posts")
    fun sendPost(@Body post: Post): Single<Post>

    @GET("posts/{id}")
    fun getPost(@Path("id") id: Int): Single<Post>

    @PUT("posts/{id}")
    fun putPost(@Path("id") id: Int, @Body post: Post): Single<Post>
}