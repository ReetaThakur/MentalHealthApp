package com.application.mentalhealth.splashandonboarding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.application.mentalhealth.R
import kotlinx.android.synthetic.main.fragment_fifth_screen.*
import kotlinx.android.synthetic.main.fragment_fifth_screen.view.*

class FifthScreen : Fragment(R.layout.fragment_fifth_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnNext5.setOnClickListener {
            findNavController().navigate(R.id.action_fifthScreen_to_onBoardingBottomSheetFragment)
        }
    }
}