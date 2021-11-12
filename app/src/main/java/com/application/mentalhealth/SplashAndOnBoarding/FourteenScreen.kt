package com.application.mentalhealth.SplashAndOnBoarding

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.application.mentalhealth.R

class FourteenScreen : Fragment(R.layout.fragment_fourteen_screen) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val handler : Handler = Handler()
        handler.postDelayed(Runnable {
            kotlin.run {
                findNavController().navigate(R.id.action_fourteenScreen_to_homeActivity)
            }
        },2000)

    }
}