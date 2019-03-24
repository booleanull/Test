package com.boolenull.test.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose

@Entity
data class Post(@Expose
                val userId: Int?,
                @PrimaryKey
                @Expose
                val id: Int,
                @Expose
                val title: String,
                @Expose
                val body: String) {

    override fun toString(): String {
        return "userId: $userId\nid: $id\ntitle: $title\ndescription: $body"
    }
}