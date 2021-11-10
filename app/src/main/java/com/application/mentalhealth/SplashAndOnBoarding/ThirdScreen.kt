package com.application.mentalhealth.SplashAndOnBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.application.mentalhealth.R
import kotlinx.android.synthetic.main.fragment_third_screen.*
import kotlinx.android.synthetic.main.fragment_third_screen.view.*

class ThirdScreen : Fragment(R.layout.fragment_third_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.btnNext3.setOnClickListener {
            findNavController().navigate(R.id.action_thirdScreen_to_login)
        }
        skipText.setOnClickListener {
            findNavController().navigate(R.id.action_thirdScreen_to_fourthScreen)
        }
    }
}