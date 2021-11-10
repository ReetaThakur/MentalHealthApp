package com.application.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.constraintlayout.utils.widget.ImageFilterButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.adapters.AddHabitAdapter
import com.application.dataClasses.AddHabitItems
import com.application.mentalhealth.R


class MyHabitsFragment : Fragment(R.layout.fragment_my_habits) {

    private lateinit var addButton:ImageView
    private lateinit var recyclerView:RecyclerView
    private lateinit var habitList:ArrayList<AddHabitItems>
    private lateinit var habitAdapter: AddHabitAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addButton=view.findViewById(R.id.btnAddHabits)
        recyclerView=view.findViewById(R.id.habitRecyclerView)
        habitList=ArrayList()
       // setData1()
        habitAdapter=AddHabitAdapter(habitList)

        recyclerView.adapter=habitAdapter
        recyclerView.layoutManager=GridLayoutManager(context,2)


        addButton.setOnClickListener {
            setData()
        }


    }

//   fun setData1() {
//       for (i in 1..10) {
//           habitList.add(AddHabitItems("morning", "7:30"))
//           habitList.add(AddHabitItems("Walk", "5:20"))
//       }
//   }

    private fun setData() {
       val view=LayoutInflater.from(context).inflate(R.layout.habit_layout,null)
        val addDialog=AlertDialog.Builder(context)
        val habitName=view.findViewById<EditText>(R.id.etCreateHabit)
        val habitTiming=view.findViewById<EditText>(R.id.etHabitTiming)
        addDialog.setView(view)
        addDialog.setPositiveButton("ok"){
                dialog,_ ->
            val name=habitName.text.toString()
            val timin=habitTiming.text.toString()
            habitList.add(AddHabitItems(name,timin))
            habitAdapter.notifyDataSetChanged()
            dialog.dismiss()
        }

    recyclerView.adapter=habitAdapter
    recyclerView.layoutManager=GridLayoutManager(context,2)
        addDialog.setNegativeButton("Cancle"){
            dialog,_ ->
            dialog.dismiss()
        }
        addDialog.create()
        addDialog.show()
    }

}