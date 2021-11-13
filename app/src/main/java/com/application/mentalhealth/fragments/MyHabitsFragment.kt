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
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.mentalhealth.adapters.AddHabitAdapter
import com.application.mentalhealth.dataClasses.AddHabitItems
import com.application.mentalhealth.R
import com.application.mentalhealth.database.HabitViewModel
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.choose_habit_layout.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MyHabitsFragment : Fragment(R.layout.fragment_my_habits) {

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

   private lateinit var viewModel:HabitViewModel
   lateinit var radioGroup: RadioGroup

   lateinit var addHabitCancle:ImageView
   lateinit var createHabitCancel:ImageView
   lateinit var deleteHabit:TextView


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
            habitAdapter.setListData(ArrayList(it))
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
       addHabitCancle=dialog.findViewById(R.id.addHabitCancle)
       dialog.show()
       addHabitCancle.setOnClickListener { dialog.dismiss() }

       createHabit.setOnClickListener {
           dialog.dismiss()
           dialog.setContentView(R.layout.choose_habit_layout)
           dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
           setTimeText=dialog.findViewById(R.id.setTime)
           radioGroup=dialog.findViewById(R.id.radioGroup)
           createHabitCancel=dialog.findViewById(R.id.habitcreateCancle)
           deleteHabit=dialog.findViewById(R.id.deleteHabit)

           createHabitCancel.setOnClickListener { dialog.dismiss() }
           deleteHabit.setOnClickListener { dialog.dismiss() }

           saveHabit=dialog.findViewById(R.id.btnSaveHabit)
           enterHabit=dialog.findViewById(R.id.etEnterHabit)
           enterTime=dialog.findViewById(R.id.setTime)
           dialog.show()
           setTimeText.setOnClickListener {
               setTime()
           }

          // lateinit var setImage: ImageView
//           radioGroup.setOnCheckedChangeListener { radioGroup, i ->
//
//               when (i) {
//                   R.id.radioButton1 -> setImage.setImageResource(R.drawable.fill_circle)
//                   R.id.radioButton2 -> setImage.setImageResource(R.drawable.heart_fill)
//                   R.id.radioButton3 -> setImage.setImageResource(R.drawable.fill_star)
//               }
//           }

           saveHabit.setOnClickListener {
               val habitName=enterHabit.text.toString()
               val habitTiming=enterTime.text.toString()



               val habit=AddHabitItems(habitName,habitTiming)

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



}