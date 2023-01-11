package com.mohamedbenrejeb.cleanarchitecturesample.post.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mohamedbenrejeb.cleanarchitecturesample.post.ui.state.PostUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostItem(
    modifier: Modifier = Modifier,
    postUiState: PostUiState,
    onClick: () -> Unit,
) {
    Card(
        onClick = onClick,
        modifier = modifier
    ) {
        Box(
            contentAlignment = Alignment.BottomStart,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            AsyncImage(
                model = postUiState.imageUrl,
                contentDescription = postUiState.title,
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(.6f)
                    .background(MaterialTheme.colorScheme.onBackground)
            )

            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = postUiState.title,
                    color = MaterialTheme.colorScheme.background,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = postUiState.description,
                    color = MaterialTheme.colorScheme.background,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostItemPreview() {
    PostItem(
        onClick = {},
        postUiState = PostUiState(
            id = "fsdfsd",
            title = "Hello",
            description = "Lorem ipsum fsdfdsfds",
            imageUrl = "https://images.unsplash.com/photo-1661956601030-fdfb9c7e9e2f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=742&q=80"
        )
    )
}