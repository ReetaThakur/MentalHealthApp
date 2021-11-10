package com.application.mentalhealth.SplashAndOnBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.application.mentalhealth.R
import kotlinx.android.synthetic.main.fragment_on_boarding_bottom_sheet_nine.*

class OnBoardingBottomSheetFragmentNine : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding_bottom_sheet_nine, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_Extremely9.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingBottomSheetFragmentNine_to_tenthScreen)

        }
        btn_Considerably9.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingBottomSheetFragmentNine_to_tenthScreen)

        }
        btn_Slightly9.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingBottomSheetFragmentNine_to_tenthScreen)

        }
        btn_NotAtAll9.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingBottomSheetFragmentNine_to_tenthScreen)

        }
    }
}