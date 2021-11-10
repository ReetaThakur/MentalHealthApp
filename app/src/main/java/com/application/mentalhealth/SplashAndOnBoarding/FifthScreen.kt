package com.application.mentalhealth.SplashAndOnBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.application.mentalhealth.R
import kotlinx.android.synthetic.main.fragment_fifth_screen.*

class FifthScreen : Fragment(R.layout.fragment_fifth_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnNext51.setOnClickListener {
            findNavController().navigate(R.id.action_fifthScreen_to_onBoardingBottomSheetFragmentFive)
        }
        btnNext5.setOnClickListener {
            findNavController().navigate(R.id.action_fifthScreen_to_sixthScreen)
        }
    }
}