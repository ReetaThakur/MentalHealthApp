package com.application.mentalhealth.splashandonboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.application.mentalhealth.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_on_boarding_bottom_sheet_eight.*
import kotlinx.android.synthetic.main.fragment_on_boarding_bottom_sheet_five.*
import kotlinx.android.synthetic.main.fragment_on_boarding_bottom_sheet_five.btn_Extremely5

class OnBoardingBottomSheetFragmentEight : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding_bottom_sheet_eight, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_Extremely8.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingBottomSheetFragmentEight_to_ninethScreen)

        }
    }
}