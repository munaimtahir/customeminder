package com.example.remindermatrix.data.repository

import com.example.remindermatrix.data.local.TaskDao
import com.example.remindermatrix.data.model.TaskEntity
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import java.util.Date

class RoomTaskRepositoryTest {

    private lateinit var repository: RoomTaskRepository
    private val taskDao = mock(TaskDao::class.java)

    @Before
    fun setup() {
        repository = RoomTaskRepository(taskDao)
    }

    @Test
    fun `insertTask calls dao`() = runBlocking {
        val task = TaskEntity(
            text = "Test task",
            groupId = 1,
            scheduleId = 1,
            channelsJson = "[]",
            status = "pending",
            createdAt = Date(),
            nextRunAt = Date()
        )
        repository.insertTask(task)
        verify(taskDao).insertTask(task)
    }
}
