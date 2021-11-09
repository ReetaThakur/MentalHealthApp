package com.application.mentalhealth.SplashAndOnBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.application.mentalhealth.R
import kotlinx.android.synthetic.main.fragment_second_screen.view.*

class SecondScreen : Fragment(R.layout.fragment_second_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.btnNext2.setOnClickListener {
            findNavController().navigate(R.id.action_secondScreen_to_thirdScreen)
        }
    }
}