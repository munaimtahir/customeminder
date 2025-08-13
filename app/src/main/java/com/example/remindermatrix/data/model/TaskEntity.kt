package com.example.remindermatrix.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val text: String,
    val groupId: Int,
    val scheduleId: Int,
    val channelsJson: String,
    val status: String,
    val createdAt: Long,
    val nextRunAt: Long
)
