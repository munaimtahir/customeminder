package com.example.remindermatrix.domain.usecase

import com.example.remindermatrix.data.model.TaskEntity
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun insertTask(task: TaskEntity)
    suspend fun updateTask(task: TaskEntity)
    fun getAllTasks(): Flow<List<TaskEntity>>
}
