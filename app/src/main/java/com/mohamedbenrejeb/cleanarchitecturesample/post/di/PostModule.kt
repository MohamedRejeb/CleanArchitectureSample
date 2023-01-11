package com.mohamedbenrejeb.cleanarchitecturesample.post.di

import com.mohamedbenrejeb.cleanarchitecturesample.post.data.repository.PostRepositoryImpl
import com.mohamedbenrejeb.cleanarchitecturesample.post.domain.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PostModule {

    @Provides
    @Singleton
    fun providePostRepository(
        postRepositoryImpl: PostRepositoryImpl
    ): PostRepository {
        return postRepositoryImpl
    }

}