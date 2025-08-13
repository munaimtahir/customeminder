package com.example.remindermatrix.data.repository

import com.example.remindermatrix.data.local.TaskDao
import com.example.remindermatrix.data.model.TaskEntity
import com.example.remindermatrix.domain.usecase.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RoomTaskRepository @Inject constructor(
    private val taskDao: TaskDao
) : TaskRepository {
    override suspend fun insert(task: TaskEntity) {
        taskDao.insert(task)
    }

    override suspend fun update(task: TaskEntity) {
        taskDao.update(task)
    }

    override fun getTaskById(id: Int): Flow<TaskEntity> {
        return taskDao.getTaskById(id)
    }

    override fun getAllTasks(): Flow<List<TaskEntity>> {
        return taskDao.getAllTasks()
    }

    override fun getTasksToRun(time: Long): Flow<List<TaskEntity>> {
        return taskDao.getTasksToRun(time)
    }
}
