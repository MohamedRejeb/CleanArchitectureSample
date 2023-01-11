package com.mohamedbenrejeb.cleanarchitecturesample.post.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mohamedbenrejeb.cleanarchitecturesample.post.domain.model.Post
import com.mohamedbenrejeb.cleanarchitecturesample.post.ui.state.PostUiState

@Composable
fun PostColumn(
    onPostClicked: (PostUiState) -> Unit,
    posts: List<PostUiState>,
    modifier: Modifier = Modifier
) {
    
    LazyColumn(modifier = modifier) {
        items(posts, key = { it.id }) { post ->
            PostItem(
                onClick = { onPostClicked(post) },
                postUiState = post,
                modifier = Modifier
                    .padding(bottom = 20.dp)
            )
        }
    }
    
}

@Preview(showBackground = true)
@Composable
fun PostColumnPreview() {
    PostColumn(
        onPostClicked = {},
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
}