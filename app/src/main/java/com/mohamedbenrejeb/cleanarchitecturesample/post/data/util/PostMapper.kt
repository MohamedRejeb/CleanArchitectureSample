package com.mohamedbenrejeb.cleanarchitecturesample.post.data.util

import com.mohamedbenrejeb.cleanarchitecturesample.post.data.remote.response.PostResponse
import com.mohamedbenrejeb.cleanarchitecturesample.post.domain.model.Post
import java.util.UUID

object PostMapper {

    fun PostResponse.toPost() = Post(
        id = id ?: UUID.randomUUID().toString(),
        title = title ?: "",
        description = description ?: "",
        imageUrl = imageUrl ?: ""
    )

}