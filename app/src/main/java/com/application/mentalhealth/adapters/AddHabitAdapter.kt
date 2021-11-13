package com.application.mentalhealth.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.application.mentalhealth.dataClasses.AddHabitItems
import com.application.mentalhealth.R

class AddHabitAdapter(var habitList: ArrayList<AddHabitItems>):RecyclerView.Adapter<AddHabitAdapter.HabitViewHolder>() {


    fun setListData(data:ArrayList<AddHabitItems>){
        this.habitList=data
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.add_habits_layout,parent,false)
        return HabitViewHolder(view)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
       val newList=habitList[position]
        holder.setData(newList)
        if (position%2==0){
            holder.cardView.setBackgroundColor(Color.parseColor("#E8BEA4"))
            holder.image.setColorFilter(Color.parseColor("#E8BEA4"))
        }else{
            holder.cardView.setBackgroundColor(Color.WHITE)
            holder.image.setColorFilter(Color.RED)
        }

    }

    override fun getItemCount(): Int {
        return habitList.size
    }


    inner class HabitViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val habitName:TextView=itemView.findViewById(R.id.tvHabitName)
        val habitTiming:TextView=itemView.findViewById(R.id.tvHabitTiming)
        val cardView:CardView=itemView.findViewById(R.id.MyHabitcardView)
        val image:ImageView=itemView.findViewById(R.id.imageView)

        fun setData(habitItems: AddHabitItems){
            habitName.text=habitItems.habitName
            habitTiming.text=habitItems.habitTime
            image.setImageResource(habitItems.category)


          //  image.setImageResource(habitItems.image)
        }
    }
}