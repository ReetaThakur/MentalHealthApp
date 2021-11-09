package com.application.mentalhealth.SplashAndOnBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.application.mentalhealth.R
import kotlinx.android.synthetic.main.fragment_eight_screen.*

class EightScreen : Fragment(R.layout.fragment_eight_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnNext8.setOnClickListener {
            findNavController().navigate(R.id.action_eightScreen_to_onBoardingBottomSheetFragmentEight)
        }
    }
}