package com.mohamedbenrejeb.cleanarchitecturesample.home.ui.state

import com.mohamedbenrejeb.cleanarchitecturesample.post.ui.state.PostUiState

data class HomeState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val posts: List<PostUiState> = emptyList()
)