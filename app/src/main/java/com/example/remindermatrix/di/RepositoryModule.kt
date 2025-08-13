package com.example.remindermatrix.di

import com.example.remindermatrix.data.repository.RoomTaskRepository
import com.example.remindermatrix.domain.usecase.TaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindTaskRepository(
        roomTaskRepository: RoomTaskRepository
    ): TaskRepository
}
