package com.example.remindermatrix.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.remindermatrix.data.model.PreferenceEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PreferenceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdatePreferences(preferences: PreferenceEntity)

    @Query("SELECT * FROM preferences WHERE userId = :userId")
    fun getPreferences(userId: Int): Flow<PreferenceEntity>
}
