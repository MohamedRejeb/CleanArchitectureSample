package com.mohamedbenrejeb.cleanarchitecturesample.post.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.mohamedbenrejeb.cleanarchitecturesample.core.util.Resource
import com.mohamedbenrejeb.cleanarchitecturesample.post.data.remote.response.PostResponse
import com.mohamedbenrejeb.cleanarchitecturesample.post.data.util.POST_COLLECTION
import com.mohamedbenrejeb.cleanarchitecturesample.post.data.util.PostMapper.toPost
import com.mohamedbenrejeb.cleanarchitecturesample.post.domain.model.Post
import com.mohamedbenrejeb.cleanarchitecturesample.post.domain.repository.PostRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val fireStore: FirebaseFirestore
): PostRepository {

    override fun getPosts(): Flow<Resource<List<Post>>> = callbackFlow {
        trySend(Resource.Loading)

        val collection = fireStore.collection(POST_COLLECTION)

        collection.addSnapshotListener { value, error ->
            if (error != null) {
                trySend(Resource.Error(
                    message = error.message,
                    exception = error
                ))
            }

            if (value == null) {
                trySend(Resource.Error(
                    message = "Data is invalid"
                ))
            } else {
                val postsResponse = value.toObjects(PostResponse::class.java)

                trySend(Resource.Success(
                    data = postsResponse.map { it.toPost() }
                ))
            }
        }

        awaitClose { cancel() }
    }

    override fun getPost(postId: String): Flow<Resource<Post>> = callbackFlow {
        trySend(Resource.Loading)

        val collection = fireStore
            .collection(POST_COLLECTION)
            .document(postId)

        collection.addSnapshotListener { value, error ->
            if (error != null) {
                trySend(Resource.Error(
                    message = error.message,
                    exception = error
                ))
            }

            val postResponse = value?.toObject(PostResponse::class.java)

            if (postResponse == null) {
                trySend(Resource.Error(
                    message = "Data is invalid"
                ))
            } else {
                trySend(Resource.Success(
                    data = postResponse.toPost()
                ))
            }
        }

        awaitClose { cancel() }
    }

}