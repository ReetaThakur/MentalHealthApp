package com.application.mentalhealth.SplashAndOnBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.application.mentalhealth.R
import kotlinx.android.synthetic.main.fragment_nineth_screen.view.*

class NinethScreen : Fragment(R.layout.fragment_nineth_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.btnNext9.setOnClickListener {
            findNavController().navigate(R.id.action_ninethScreen_to_onBoardingBottomSheetFragmentNine)
        }
    }
}