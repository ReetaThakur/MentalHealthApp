package com.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.application.dataClasses.AddHabitItems

class HabitViewModel(app:Application):AndroidViewModel(app) {

    var allHabits:MutableLiveData<List<AddHabitItems>> = MutableLiveData()

    fun getHabitsObserver():MutableLiveData<List<AddHabitItems>>{
        return allHabits
    }

    fun getAllHabits(){
        val habitDao=RoomDatabaseHabit.getDatabaseObject((getApplication()))?.getDao()
       val list=habitDao?.getHabitInfo()
        allHabits.postValue(list)
    }

    fun insertHabitsInfo(habitItems: AddHabitItems){
        val habitDao= RoomDatabaseHabit.getDatabaseObject((getApplication()))?.getDao()
        val list=habitDao?.insertHabit(habitItems)
        getAllHabits()
    }
}