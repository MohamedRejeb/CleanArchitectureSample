package com.mohamedbenrejeb.cleanarchitecturesample.post.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mohamedbenrejeb.cleanarchitecturesample.post.ui.state.PostUiState

@Composable
fun PostDetailsItem(
    modifier: Modifier = Modifier,
    postUiState: PostUiState,
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            Card {
                AsyncImage(
                    model = postUiState.imageUrl,
                    contentDescription = postUiState.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = postUiState.title,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.displayMedium
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = postUiState.description,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostDetailsItemPreview() {
    PostDetailsItem(
        postUiState = PostUiState(
            id = "fsdfsd",
            title = "Hello",
            description = "Lorem ipsum fsdfdsfds",
            imageUrl = "https://images.unsplash.com/photo-1661956601030-fdfb9c7e9e2f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=742&q=80"
        )
    )
}