package com.example.remindermatrix.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.remindermatrix.data.model.ScheduleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDao {
    @Insert
    suspend fun insert(schedule: ScheduleEntity)

    @Update
    suspend fun update(schedule: ScheduleEntity)

    @Query("SELECT * FROM schedules WHERE id = :id")
    fun getScheduleById(id: Int): Flow<ScheduleEntity>

    @Query("SELECT * FROM schedules ORDER BY name ASC")
    fun getAllSchedules(): Flow<List<ScheduleEntity>>
}
