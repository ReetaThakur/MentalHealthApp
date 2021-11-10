package com.application.mentalhealth.SplashAndOnBoarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.application.mentalhealth.R
import kotlinx.android.synthetic.main.fragment_tenth_screen.*

class TenthScreen : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnNext101.setOnClickListener {
            findNavController().navigate(R.id.action_tenthScreen_to_onBoardingBottomSheetFragmentTen)
        }
        btnNext10.setOnClickListener {
            findNavController().navigate(R.id.action_tenthScreen_to_connectorActivity)
        }
    }
    private fun onBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }
}