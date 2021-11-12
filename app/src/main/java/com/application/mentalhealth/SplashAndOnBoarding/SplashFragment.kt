package com.application.mentalhealth.SplashAndOnBoarding

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.bumptech.glide.Glide
import com.application.mentalhealth.R
import kotlinx.android.synthetic.main.fragment_splash.*

class SplashFragment : Fragment(R.layout.fragment_splash) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this).asGif().load(R.raw.splash).into(SplashImageView)
        Handler().postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_firstScreen)
        }, 5600)
    }
    private fun onBoardingFinished(): Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }
}