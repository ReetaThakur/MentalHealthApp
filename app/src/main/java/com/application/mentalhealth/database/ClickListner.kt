package com.application.mentalhealth.database

import com.application.mentalhealth.dataClasses.AddHabitItems

interface ClickListner {

    fun deleteHabit(habitItems: AddHabitItems)
}