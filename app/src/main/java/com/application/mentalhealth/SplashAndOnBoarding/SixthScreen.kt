package com.application.mentalhealth.SplashAndOnBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.application.mentalhealth.R
import kotlinx.android.synthetic.main.fragment_sixth_screen.*

class SixthScreen : Fragment(R.layout.fragment_sixth_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnNext61.setOnClickListener {
            findNavController().navigate(R.id.action_sixthScreen_to_onBoardingBottomSheetFragmentSix)
        }
        btnNext6.setOnClickListener {
            findNavController().navigate(R.id.action_sixthScreen_to_seventhScreen)
        }
    }
}