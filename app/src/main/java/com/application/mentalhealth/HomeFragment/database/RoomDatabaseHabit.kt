package com.application.mentalhealth.HomeFragment.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.application.mentalhealth.HomeFragment.dataClasses.AddHabitItems

@Database(entities = [AddHabitItems::class],version = 2)
abstract class RoomDatabaseHabit:RoomDatabase() {

    abstract fun getDao(): HabitDao

    companion object {
        private var INSTANCE:RoomDatabaseHabit?=null

        fun getDatabaseObject(context: Context):RoomDatabaseHabit{

            if (INSTANCE==null){
                val builder=Room.databaseBuilder(context.applicationContext,RoomDatabaseHabit::class.java,"HabitDataBase")
                builder.fallbackToDestructiveMigration()
                INSTANCE=builder.build()
                return INSTANCE!!
            }else{
                return INSTANCE!!
            }
        }
    }
}