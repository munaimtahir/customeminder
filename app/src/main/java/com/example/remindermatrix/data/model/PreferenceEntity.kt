package com.example.remindermatrix.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "preferences")
data class PreferenceEntity(
    @PrimaryKey val userId: String,
    val emailEnabled: Boolean,
    val pushEnabled: Boolean
)
