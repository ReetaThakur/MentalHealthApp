package com.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.application.dataClasses.AddHabitItems


@Dao
interface HabitDao {

    @Query("select * from habitTable")
    fun getHabitInfo():List<AddHabitItems>?

    @Insert
    fun insertHabit(habitItems: AddHabitItems?)
}