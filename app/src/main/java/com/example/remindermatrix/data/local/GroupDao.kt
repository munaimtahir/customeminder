package com.example.remindermatrix.data.local

import androidx.room.Dao
import androidx.room.Insert
import com.example.remindermatrix.data.model.GroupEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GroupDao {
    @Insert
    suspend fun insertGroup(group: GroupEntity)

    @Query("SELECT * FROM groups")
    fun getAllGroups(): Flow<List<GroupEntity>>
}
