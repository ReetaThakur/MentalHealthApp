package com.application.mentalhealth.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.mentalhealth.R
import com.application.mentalhealth.adapters.TodaysGoalsAdapter
import com.application.mentalhealth.dataClasses.AddHabitItems
import com.application.mentalhealth.database.HabitViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class TodayGoalsFragment : Fragment(R.layout.fragment_today_habit) {

    private lateinit var todayRecyclerView:RecyclerView
    private lateinit var viewModel:HabitViewModel
    private lateinit var list:ArrayList<AddHabitItems>
    private lateinit var todayAdapter:TodaysGoalsAdapter



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        todayRecyclerView=view.findViewById(R.id.TodayGoalsRecyclerView)

        viewModel= ViewModelProviders.of(this).get(HabitViewModel::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getAllHabits()
        }

        list= ArrayList()
        todayAdapter= TodaysGoalsAdapter(list)
        todayRecyclerView.adapter=todayAdapter
        todayRecyclerView.layoutManager=LinearLayoutManager(context)

        viewModel.getHabitsObserver().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            todayAdapter.setListData(ArrayList(it))
            todayAdapter.notifyDataSetChanged()
//            viewModel.getAllHabits()
        })

    }

}