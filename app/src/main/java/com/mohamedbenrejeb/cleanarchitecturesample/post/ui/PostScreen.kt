package com.mohamedbenrejeb.cleanarchitecturesample.post.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.mohamedbenrejeb.cleanarchitecturesample.post.ui.components.PostDetailsItem
import com.mohamedbenrejeb.cleanarchitecturesample.post.ui.navigation.PostNavigation
import com.mohamedbenrejeb.cleanarchitecturesample.post.ui.state.PostScreenState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostScreen(
    onNavigation: (PostNavigation) -> Unit
) {
    val viewModel: PostViewModel = hiltViewModel()
    val state by viewModel.postScreenState.collectAsState()

    Scaffold(
        topBar = {
            IconButton(
                onClick = {
                    onNavigation(PostNavigation.NavigateBack)
                },
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "navigate back"
                )
            }
        }
    ) { paddingValues ->
        PostScreenContent(
            state = state,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        )
    }

}

@Composable
fun PostScreenContent(
    state: PostScreenState,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        if (state.isLoading) {
            CircularProgressIndicator()
        }

        state.error?.let { error ->
            Text(text = error)
        }

        state.postUiState?.let { postUiState ->
            PostDetailsItem(
                postUiState = postUiState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
            )
        }
    }

}