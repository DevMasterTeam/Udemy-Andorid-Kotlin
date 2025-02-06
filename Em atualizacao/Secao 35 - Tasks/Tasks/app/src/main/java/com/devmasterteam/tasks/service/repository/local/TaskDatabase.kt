package com.devmasterteam.tasks.service.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.devmasterteam.tasks.service.model.PriorityModel

@Database(entities = [PriorityModel::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun priorityDAO(): PriorityDAO

    companion object {
        private lateinit var INSTANCE: TaskDatabase

        fun getDatabase(context: Context): TaskDatabase {
            if (!Companion::INSTANCE.isInitialized) {
                synchronized(TaskDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context, TaskDatabase::class.java, "tasksDB")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }

}