package com.mohamedbenrejeb.cleanarchitecturesample.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohamedbenrejeb.cleanarchitecturesample.core.util.Resource
import com.mohamedbenrejeb.cleanarchitecturesample.post.domain.model.Post
import com.mohamedbenrejeb.cleanarchitecturesample.post.domain.repository.PostRepository
import com.mohamedbenrejeb.cleanarchitecturesample.home.ui.state.HomeState
import com.mohamedbenrejeb.cleanarchitecturesample.post.ui.util.PostMapper.toPostUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val postRepository: PostRepository
): ViewModel() {

    private val _homeState = MutableStateFlow(HomeState())
    val homeState = _homeState.asStateFlow()

    init {
        getPosts()
    }

    private fun getPosts() {

        viewModelScope.launch {
            postRepository.getPosts().collect { result ->
                handleGetPostsResult(result)
            }
        }

    }

    private fun handleGetPostsResult(
        result: Resource<List<Post>>
    ) {
        when(result) {
            is Resource.Loading -> _homeState.value = HomeState(
                isLoading = true
            )

            is Resource.Success -> _homeState.value = HomeState(
                posts = result.data.map {
                    it.toPostUiState()
                }
            )

            is Resource.Error -> _homeState.value = HomeState(
                error = result.message
            )
        }
    }

}