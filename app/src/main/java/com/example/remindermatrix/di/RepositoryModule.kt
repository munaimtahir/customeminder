package com.example.remindermatrix.di

import com.example.remindermatrix.data.local.TaskDao
import com.example.remindermatrix.data.repository.RoomTaskRepository
import com.example.remindermatrix.domain.usecase.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideTaskRepository(taskDao: TaskDao): TaskRepository {
        return RoomTaskRepository(taskDao)
    }
}
