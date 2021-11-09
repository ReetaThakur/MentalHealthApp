package com.application.mentalhealth.splashandonboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.application.mentalhealth.R
import kotlinx.android.synthetic.main.fragment_sixth_screen.view.*

class SixthScreen : Fragment(R.layout.fragment_sixth_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.btnNext6.setOnClickListener {
            findNavController().navigate(R.id.action_sixthScreen_to_onBoardingBottomSheetFragment)
        }
    }
}