package com.mohamedbenrejeb.cleanarchitecturesample.post.domain.repository

import com.mohamedbenrejeb.cleanarchitecturesample.core.util.Resource
import com.mohamedbenrejeb.cleanarchitecturesample.post.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    fun getPosts(): Flow<Resource<List<Post>>>

    fun getPost(postId: String): Flow<Resource<Post>>

}