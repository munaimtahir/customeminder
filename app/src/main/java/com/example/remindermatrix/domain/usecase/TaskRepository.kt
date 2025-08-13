package com.example.remindermatrix.domain.usecase

import com.example.remindermatrix.data.model.TaskEntity
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun insert(task: TaskEntity)
    suspend fun update(task: TaskEntity)
    fun getTaskById(id: Int): Flow<TaskEntity>
    fun getAllTasks(): Flow<List<TaskEntity>>
    fun getTasksToRun(time: Long): Flow<List<TaskEntity>>
}
