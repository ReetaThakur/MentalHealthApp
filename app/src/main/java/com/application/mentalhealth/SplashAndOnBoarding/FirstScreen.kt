package com.application.mentalhealth.SplashAndOnBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.application.mentalhealth.R
import kotlinx.android.synthetic.main.fragment_first_screen.*

class FirstScreen : Fragment(R.layout.fragment_first_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnNext1.setOnClickListener {
            findNavController().navigate(R.id.action_firstScreen_to_secondScreen)
        }
    }
}