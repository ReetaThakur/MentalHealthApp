package com.application.mentalhealth.SplashAndOnBoarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.application.mentalhealth.R
import kotlinx.android.synthetic.main.fragment_tenth_screen.*
import android.content.Intent
import com.application.mentalhealth.SimpleViews.ConnectorActivity


class TenthScreen : Fragment(R.layout.fragment_tenth_screen) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnNext101.setOnClickListener {
            findNavController().navigate(R.id.action_tenthScreen_to_onBoardingBottomSheetFragmentTen)
//            val intent = Intent(context, ConnectorActivity::class.java)
//            startActivity(intent)
        }
        btnNext10.setOnClickListener {
            findNavController().navigate(R.id.action_tenthScreen_to_connectorActivity)
//            val intent = Intent(context, ConnectorActivity::class.java)
//            startActivity(intent)
        }
    }
    private fun onBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }
}