package com.application.mentalhealth.SplashAndOnBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.application.mentalhealth.R
import kotlinx.android.synthetic.main.fragment_elven_screeem.*


class ElvenScreeem : Fragment(R.layout.fragment_elven_screeem) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickhappy.setOnClickListener {
            findNavController().navigate(R.id.action_elvenScreeem_to_twelveScreen)
        }

        clickveryhappy.setOnClickListener {
            findNavController().navigate(R.id.action_elvenScreeem_to_twelveScreen)
        }

        clickmoderate.setOnClickListener {
            findNavController().navigate(R.id.action_elvenScreeem_to_twelveScreen)
        }

        clicksad.setOnClickListener {
            findNavController().navigate(R.id.action_elvenScreeem_to_twelveScreen)
        }

        clickverySad.setOnClickListener {
            findNavController().navigate(R.id.action_elvenScreeem_to_twelveScreen)
        }

    }
}