package com.example.remindermatrix.data.repository

import com.example.remindermatrix.data.local.TaskDao
import com.example.remindermatrix.data.model.TaskEntity
import com.example.remindermatrix.domain.usecase.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RoomTaskRepository @Inject constructor(
    private val taskDao: TaskDao
) : TaskRepository {
    override suspend fun insertTask(task: TaskEntity) {
        taskDao.insertTask(task)
    }

    override suspend fun updateTask(task: TaskEntity) {
        taskDao.updateTask(task)
    }

    override fun getAllTasks(): Flow<List<TaskEntity>> {
        return taskDao.getAllTasks()
    }
}
