package com.application.mentalhealth.splashandonboarding

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.application.mentalhealth.R
import kotlinx.android.synthetic.main.fragment_fourth_screen.view.*

class FourthScreen : Fragment(R.layout.fragment_fourth_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.btnNext4.setOnClickListener {
            findNavController().navigate(R.id.action_fourthScreen_to_loginAndSignUpFragment)
        }
    }
}