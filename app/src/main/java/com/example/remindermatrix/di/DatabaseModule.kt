package com.example.remindermatrix.di

import android.content.Context
import androidx.room.Room
import com.example.remindermatrix.data.local.AppDatabase
import com.example.remindermatrix.data.local.GroupDao
import com.example.remindermatrix.data.local.PreferenceDao
import com.example.remindermatrix.data.local.ScheduleDao
import com.example.remindermatrix.data.local.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "reminder-matrix.db"
        ).build()
    }

    @Provides
    fun provideTaskDao(appDatabase: AppDatabase): TaskDao {
        return appDatabase.taskDao()
    }

    @Provides
    fun provideGroupDao(appDatabase: AppDatabase): GroupDao {
        return appDatabase.groupDao()
    }

    @Provides
    fun provideScheduleDao(appDatabase: AppDatabase): ScheduleDao {
        return appDatabase.scheduleDao()
    }

    @Provides
    fun providePreferenceDao(appDatabase: AppDatabase): PreferenceDao {
        return appDatabase.preferenceDao()
    }
}
