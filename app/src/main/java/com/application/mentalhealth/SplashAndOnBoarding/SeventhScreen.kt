package com.application.mentalhealth.SplashAndOnBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.application.mentalhealth.R
import kotlinx.android.synthetic.main.fragment_seventh_screen.*

class SeventhScreen : Fragment(R.layout.fragment_seventh_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnNext71.setOnClickListener {
            findNavController().navigate(R.id.action_seventhScreen_to_onBoardingBottomSheetFragmentSeven)
        }
        btnNext7.setOnClickListener {
            findNavController().navigate(R.id.action_seventhScreen_to_eightScreen)
        }

    }
}