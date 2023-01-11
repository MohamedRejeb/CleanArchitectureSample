package com.mohamedbenrejeb.cleanarchitecturesample.post.data.remote.response

import com.google.firebase.Timestamp

data class PostResponse(
    val id: String? = null,
    val date: Timestamp? = null,
    val title: String? = null,
    val numberOfLike : Int = 0,
    val numberOfComment: Int? = null,
    val imageUrl : String? = null,
    val description : String? = null,
    val userId: String? = null
)