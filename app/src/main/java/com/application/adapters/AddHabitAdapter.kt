package com.application.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.application.dataClasses.AddHabitItems
import com.application.mentalhealth.R

class AddHabitAdapter(var habitList: ArrayList<AddHabitItems>):RecyclerView.Adapter<AddHabitAdapter.HabitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.habits_item_layout,parent,false)
        return HabitViewHolder(view)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
       val newList=habitList[position]
        holder.setData(newList)
    }

    override fun getItemCount(): Int {
        return habitList.size
    }


    inner class HabitViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val habitName:TextView=itemView.findViewById(R.id.tvHabitName)
        val habitTiming:TextView=itemView.findViewById(R.id.tvHabitTiming)

        fun setData(habitItems: AddHabitItems){
            habitName.text=habitItems.habitName
            habitTiming.text=habitItems.habitTiming
        }
    }
}