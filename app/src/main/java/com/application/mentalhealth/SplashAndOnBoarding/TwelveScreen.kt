package com.application.mentalhealth.SplashAndOnBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.application.mentalhealth.R
import kotlinx.android.synthetic.main.fragment_twelve_screen.*


class TwelveScreen : Fragment(R.layout.fragment_twelve_screen) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setreminder.setOnClickListener {
            Toast.makeText(activity, "Reminder Set", Toast.LENGTH_SHORT).show()
        }

        maybelater.setOnClickListener {
            findNavController().navigate(R.id.action_twelveScreen_to_thirteenScreen)
        }
    }
}