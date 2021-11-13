package com.application.mentalhealth.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.application.mentalhealth.dataClasses.AddHabitItems


@Dao
interface HabitDao {

    @Query("select * from habitTable")
    fun getHabitInfo():List<AddHabitItems>?

    @Insert
    fun insertHabit(habitItems: AddHabitItems?)

    @Delete
    fun deleteHabit(habitItems: AddHabitItems?)
}