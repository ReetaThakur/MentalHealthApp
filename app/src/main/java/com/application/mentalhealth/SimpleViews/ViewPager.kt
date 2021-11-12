package com.application.mentalhealth.SimpleViews

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.application.mentalhealth.fragments.AllFragment
import com.application.mentalhealth.fragments.MeditateFragment
import com.application.mentalhealth.fragments.ReadFragment
import com.application.mentalhealth.fragments.SleepFragment

class ViewPager(fragmentManager : FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(
    fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when(position) {
            0 -> return  AllFragment()
            1 -> return ReadFragment()
            2 -> return MeditateFragment()
            3 -> return SleepFragment()
        }
        return null!!
    }
}