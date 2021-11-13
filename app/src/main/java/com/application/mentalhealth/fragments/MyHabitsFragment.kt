package com.application.mentalhealth.fragments

import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.mentalhealth.adapters.AddHabitAdapter
import com.application.mentalhealth.dataClasses.AddHabitItems
import com.application.mentalhealth.R
import com.application.mentalhealth.database.HabitViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MyHabitsFragment : Fragment(R.layout.fragment_my_habits), View.OnClickListener {

    private lateinit var addButton:FloatingActionButton
    private lateinit var recyclerView:RecyclerView
    private lateinit var habitList:ArrayList<AddHabitItems>
    private lateinit var habitAdapter: AddHabitAdapter
    private lateinit var dialog: Dialog
    private lateinit var createHabit: Button
    private lateinit var saveHabit:AppCompatButton
   private lateinit var setTimeText:TextView
   private lateinit var enterHabit:EditText
   private lateinit var enterTime:TextView
   private lateinit var circleDefault:ImageView
    private lateinit var heartSelfLove:ImageView
    private lateinit var starImpotant:ImageView
    private lateinit var image:ImageView
   private lateinit var viewModel:HabitViewModel


   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addButton=view.findViewById(R.id.btnAddHabits)
        viewModel= ViewModelProviders.of(this).get(HabitViewModel::class.java)

       CoroutineScope(Dispatchers.IO).launch {
           viewModel.getAllHabits()
       }


        dialog= context?.let { Dialog(it) }!!


        recyclerView=view.findViewById(R.id.habitRecyclerView)
        habitList=ArrayList()
        habitAdapter=AddHabitAdapter(habitList)

        recyclerView.adapter=habitAdapter
        recyclerView.layoutManager=GridLayoutManager(context,2)

        viewModel.getHabitsObserver().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            habitList.addAll(it)
            habitAdapter.notifyDataSetChanged()
        })


        addButton.setOnClickListener {
          setDialogBox()
        }
    }

   fun setDialogBox(){
       dialog.setContentView(R.layout.dialogbox_create_habits_layout)
       dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
       createHabit=dialog.findViewById(R.id.btnCreateHabit)

       dialog.show()

       createHabit.setOnClickListener {
           dialog.dismiss()
           dialog.setContentView(R.layout.choose_habit_layout)
           dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
           setTimeText=dialog.findViewById(R.id.setTime)
           circleDefault=dialog.findViewById(R.id.circleDefault)
           heartSelfLove=dialog.findViewById(R.id.heartSelfCare)
           starImpotant=dialog.findViewById(R.id.startImpotant)
           saveHabit=dialog.findViewById(R.id.btnSaveHabit)
           enterHabit=dialog.findViewById(R.id.etEnterHabit)
           enterTime=dialog.findViewById(R.id.setTime)
           dialog.show()
           setTimeText.setOnClickListener {
               setTime()
           }
           saveHabit.setOnClickListener {
               val habitName=enterHabit.text.toString()
               val habitTiming=enterTime.text.toString()
               val habit=AddHabitItems(habitName,habitTiming,image.toString().toInt())

               CoroutineScope(Dispatchers.IO).launch {
                   viewModel.insertHabitsInfo(habit)
               }

             //  habitList.add(AddHabitItems(habitName,habitTiming))
               habitAdapter.notifyDataSetChanged()
               dialog.dismiss()
           }

       }

    }

    private fun setTime() {
          val calendar=Calendar.getInstance()
          var hour:Int=calendar.get(Calendar.HOUR_OF_DAY)
          var mins:Int=calendar.get(Calendar.MINUTE)
          val timePickerDialog = TimePickerDialog(context, R.style.Theme_AppCompat_Dialog,
              OnTimeSetListener { view, hourOfDay, minute ->
                  val calendar = Calendar.getInstance()
                  calendar[Calendar.HOUR_OF_DAY] = hourOfDay
                  calendar[Calendar.MINUTE] = minute
                  val format = SimpleDateFormat("k:mm a")
                  val time = format.format(calendar.time)
                  setTimeText.text=time
              }, hour, mins, false)
          timePickerDialog.show()
    }

    override fun onClick(p0: View?) {
        var id=p0?.id
        when(id){
            R.id.circleDefault -> image.setImageResource(R.drawable.mark)
            R.id.heartSelfCare -> image.setImageResource(R.drawable.heart_fill)
            R.id.startImpotant -> image.setImageResource(R.drawable.star)

        }
    }


}