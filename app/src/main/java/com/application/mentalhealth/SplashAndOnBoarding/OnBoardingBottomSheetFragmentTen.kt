package com.application.mentalhealth.SplashAndOnBoarding

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.application.mentalhealth.R
import com.application.mentalhealth.SimpleViews.ConnectorActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_on_boarding_bottom_sheet_ten.*

class OnBoardingBottomSheetFragmentTen : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding_bottom_sheet_ten, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_Extremely10.setOnClickListener {
           // findNavController().navigate(R.id.action_onBoardingBottomSheetFragmentTen_to_connectorActivity)
            val intent = Intent(context, ConnectorActivity::class.java)
            startActivity(intent)
        }
        btn_Considerably10.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingBottomSheetFragmentTen_to_connectorActivity)

        }
        btn_Slightly10.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingBottomSheetFragmentTen_to_connectorActivity)

        }
        btn_NotAtAll10.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingBottomSheetFragmentTen_to_connectorActivity)

        }
    }
}