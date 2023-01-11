package com.mohamedbenrejeb.cleanarchitecturesample.post.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohamedbenrejeb.cleanarchitecturesample.core.util.Resource
import com.mohamedbenrejeb.cleanarchitecturesample.post.domain.model.Post
import com.mohamedbenrejeb.cleanarchitecturesample.post.domain.repository.PostRepository
import com.mohamedbenrejeb.cleanarchitecturesample.post.ui.state.PostScreenState
import com.mohamedbenrejeb.cleanarchitecturesample.post.ui.util.PostMapper.toPostUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val postRepository: PostRepository
): ViewModel() {

    private val postId: String = checkNotNull(savedStateHandle["postId"])

    private val _postScreenState = MutableStateFlow(PostScreenState())
    val postScreenState = _postScreenState.asStateFlow()

    init {
        getPost()
    }

    private fun getPost() {
        viewModelScope.launch {
            postRepository.getPost(postId).collect { result ->
                handlePostResult(result)
            }
        }
    }

    private fun handlePostResult(result: Resource<Post>) {
        when(result) {
            Resource.Loading -> _postScreenState.value = PostScreenState(
                isLoading = true
            )

            is Resource.Success -> _postScreenState.value = PostScreenState(
                postUiState = result.data.toPostUiState()
            )

            is Resource.Error -> _postScreenState.value = PostScreenState(
                error = result.message
            )
        }
    }

}