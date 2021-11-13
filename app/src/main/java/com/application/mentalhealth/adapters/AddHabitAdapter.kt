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
import com.application.mentalhealth.database.ClickListner

class AddHabitAdapter(var habitList: ArrayList<AddHabitItems>,var listner: ClickListner):RecyclerView.Adapter<AddHabitAdapter.HabitViewHolder>() {


    fun setListData(data:ArrayList<AddHabitItems>){
        this.habitList=data
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.add_habits_layout,parent,false)
        return HabitViewHolder(view,listner)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
       val newList=habitList[position]
        holder.setData(newList)
    }

    override fun getItemCount(): Int {
        return habitList.size
    }


    inner class HabitViewHolder(itemView:View,val listner: ClickListner):RecyclerView.ViewHolder(itemView){
        val habitName:TextView=itemView.findViewById(R.id.tvHabitName)
        val habitTiming:TextView=itemView.findViewById(R.id.tvHabitTiming)
        val cardView:CardView=itemView.findViewById(R.id.MyHabitcardView)
        val image:ImageView=itemView.findViewById(R.id.imageView)

        fun setData(habitItems: AddHabitItems){
            habitName.text=habitItems.habitName
            habitTiming.text=habitItems.habitTime
            if(adapterPosition==0 || adapterPosition%5==0){
                cardView.setBackgroundColor(Color.parseColor("#E8BEA4"))
                image.setColorFilter(Color.parseColor("#DC9D76"))
            }else if (adapterPosition%2==0 || adapterPosition==7||adapterPosition==1) {
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
                listner.deleteHabit(habitItems)
                return@setOnLongClickListener true
            }
        }
    }
}