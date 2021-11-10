package com.application.mentalhealth.SplashAndOnBoarding.login

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.application.mentalhealth.SplashAndOnBoarding.login.extra.LogInFragment
import com.application.mentalhealth.SplashAndOnBoarding.login.extra.SignUpFragment

class PagerAdaptor(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 2
    }


    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return SignUpFragment()
            1 -> return LogInFragment()
        }
        return null!!
    }
}