package com.boolenull.test.model

import com.google.gson.annotations.Expose

data class Post(@Expose
                val userId: Int?,
                @Expose
                val id: Int,
                @Expose
                val title: String,
                @Expose
                val body: String)