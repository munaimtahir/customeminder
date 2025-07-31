package com.example.remindermatrix.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.remindermatrix.data.model.TaskEntity
import kotlinx.coroutines.flow.Flow
import java.util.Date

@Dao
interface TaskDao {
    @Insert
    suspend fun insertTask(task: TaskEntity)

    @Update
    suspend fun updateTask(task: TaskEntity)

    @Query("SELECT * FROM tasks ORDER BY nextRunAt ASC")
    fun getAllTasks(): Flow<List<TaskEntity>>

    @Query("SELECT * FROM tasks WHERE nextRunAt <= :date ORDER BY nextRunAt ASC")
    fun getTasksToRun(date: Date): Flow<List<TaskEntity>>
}
