package com.mohamedbenrejeb.cleanarchitecturesample.post.ui.util

import com.mohamedbenrejeb.cleanarchitecturesample.post.domain.model.Post
import com.mohamedbenrejeb.cleanarchitecturesample.post.ui.state.PostUiState

object PostMapper {

    fun Post.toPostUiState() = PostUiState(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl
    )

}