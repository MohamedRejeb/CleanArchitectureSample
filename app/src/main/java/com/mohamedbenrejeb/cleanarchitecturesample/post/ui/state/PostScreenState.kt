package com.mohamedbenrejeb.cleanarchitecturesample.post.ui.state

data class PostScreenState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val postUiState: PostUiState? = null
)