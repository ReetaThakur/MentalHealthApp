package com.application.mentalhealth.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.application.mentalhealth.R
import com.application.mentalhealth.dataClasses.AddHabitItems
import com.application.mentalhealth.database.ClickListner

class TodaysGoalsAdapter(var list:ArrayList<AddHabitItems>,var listner: ClickListner):RecyclerView.Adapter<TodaysGoalsAdapter.TodaysViewHolder>() {


    fun setListData(data:ArrayList<AddHabitItems>){
        this.list=data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodaysViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.todays_goal_layout,parent,false)
        return TodaysViewHolder(view,listner)
    }

    override fun onBindViewHolder(holder: TodaysViewHolder, position: Int) {
        var habitList=list[position]
        holder.setData(habitList)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class TodaysViewHolder(itemView:View,var listner: ClickListner):RecyclerView.ViewHolder(itemView){
        var habitName:TextView=itemView.findViewById(R.id.habitName)
        var habitTime:TextView=itemView.findViewById(R.id.habitTime)
        var cardView:CardView=itemView.findViewById(R.id.cardView)
        var image:ImageView=itemView.findViewById(R.id.markerOfHabit)
        fun setData(habit:AddHabitItems){
            habitName.text=habit.habitName
            habitTime.text=habit.habitTime
            if(adapterPosition==0 || adapterPosition%5==0){
                cardView.setBackgroundColor(Color.parseColor("#E8BEA4"))
                image.setColorFilter(Color.parseColor("#DC9D76"))
            }else if (adapterPosition%2==0) {
                cardView.setBackgroundColor(Color.parseColor("#A8D9D2"))
                image.setColorFilter(Color.parseColor("#7CC7BB"))
            }else if (adapterPosition%3==0){
                cardView.setBackgroundColor(Color.parseColor("#9CB1B7"))
                image.setColorFilter(Color.parseColor("#6A8994"))
            }else if (adapterPosition==11 ||adapterPosition==13 ||adapterPosition==17 ||adapterPosition==19 ||adapterPosition==23){
                cardView.setBackgroundColor(Color.parseColor("#7B7884"))
                image.setColorFilter(Color.parseColor("#88C7CE"))
            }else{
                cardView.setBackgroundColor(Color.parseColor("#D1A99B"))
                image.setColorFilter(Color.parseColor("#B97E68"))
            }

            cardView.setOnLongClickListener {
                listner.deleteHabit(habit)
                return@setOnLongClickListener true
            }
        }

    }

}