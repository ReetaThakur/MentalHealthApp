package com.application.mentalhealth.SplashAndOnBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.application.mentalhealth.R
import kotlinx.android.synthetic.main.fragment_thirteen_screen.*

class ThirteenScreen : Fragment(R.layout.fragment_thirteen_screen) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn13.setOnClickListener {
            findNavController().navigate(R.id.action_thirteenScreen_to_fourteenScreen)
        }
    }

}