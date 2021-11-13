package com.application.mentalhealth.HomeFragment.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.application.mentalhealth.fragments.MyHabitsFragment
import com.application.mentalhealth.fragments.TodayGoalsFragment

class  PageAdapter(val fm:FragmentManager,var behavior:Int): FragmentPagerAdapter(fm,behavior) {

    var tabcount:Int=behavior

    override fun getCount(): Int {
        return tabcount
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> TodayGoalsFragment()
            1 -> MyHabitsFragment()
            else -> null!!
        }

    }
}