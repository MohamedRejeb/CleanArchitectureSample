package com.mohamedbenrejeb.cleanarchitecturesample.home.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mohamedbenrejeb.cleanarchitecturesample.home.ui.navigation.HomeNavigation
import com.mohamedbenrejeb.cleanarchitecturesample.post.ui.components.PostColumn
import com.mohamedbenrejeb.cleanarchitecturesample.post.ui.state.PostUiState
import com.mohamedbenrejeb.cleanarchitecturesample.home.ui.state.HomeState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigation: (HomeNavigation) -> Unit
) {
    val viewModel: HomeViewModel = hiltViewModel()
    val state by viewModel.homeState.collectAsState()

    Scaffold(
        topBar = {
            Text(
                text = "Welcome John",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .padding(20.dp)
            )
        }
    ) { paddingValues ->
        HomeScreenContent(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
            ,
            state = state,
            onNavigation = onNavigation
        )
    }

}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    state: HomeState,
    onNavigation: (HomeNavigation) -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        if (state.isLoading) {
            CircularProgressIndicator()
        }

        state.error?.let { error ->
            Text(text = error)
        }

        PostColumn(
            onPostClicked = { post ->
                onNavigation(HomeNavigation.NavigateToPost(
                    postId = post.id
                ))
            },
            posts = state.posts,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenContentPreview() {

    HomeScreenContent(
        onNavigation = {},
        state = HomeState(
            posts = listOf(
                PostUiState(
                    id = "fsdfsd",
                    title = "Hello",
                    description = "Lorem ipsum fsdfdsfds",
                    imageUrl = "https://images.unsplash.com/photo-1661956601030-fdfb9c7e9e2f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=742&q=80"
                ),
                PostUiState(
                    id = "fsdfsfsdfdsfdsd",
                    title = "Hello",
                    description = "Lorem ipsum fsdfdsfds",
                    imageUrl = "https://images.unsplash.com/photo-1661956601030-fdfb9c7e9e2f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=742&q=80"
                ),
                PostUiState(
                    id = "fsdfsdfsdfsd",
                    title = "Hello",
                    description = "Lorem ipsum fsdfdsfds",
                    imageUrl = "https://images.unsplash.com/photo-1661956601030-fdfb9c7e9e2f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=742&q=80"
                ),
                PostUiState(
                    id = "fsdfdsfdsfsd",
                    title = "Hello",
                    description = "Lorem ipsum fsdfdsfds",
                    imageUrl = "https://images.unsplash.com/photo-1661956601030-fdfb9c7e9e2f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=742&q=80"
                )
            )
        )
    )

}