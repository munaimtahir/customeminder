package com.example.remindermatrix.data.local

import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Before
import org.junit.Test
import com.example.remindermatrix.data.model.TaskEntity
import java.util.Date
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals

@RunWith(JUnit4::class)
class TaskDaoTest {

    private lateinit var taskDao: TaskDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        // TODO: implement in-memory db for testing
    }

    @Test
    fun writeTaskAndReadInList() = runBlocking {
        // TODO: implement test
    }
}
