package com.example.remindermatrix.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.remindermatrix.data.model.GroupEntity
import com.example.remindermatrix.data.model.PreferenceEntity
import com.example.remindermatrix.data.model.ScheduleEntity
import com.example.remindermatrix.data.model.TaskEntity

@Database(
    entities = [TaskEntity::class, GroupEntity::class, ScheduleEntity::class, PreferenceEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
    abstract fun groupDao(): GroupDao
    abstract fun scheduleDao(): ScheduleDao
    abstract fun preferenceDao(): PreferenceDao
}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // TODO: Implement migration
    }
}
