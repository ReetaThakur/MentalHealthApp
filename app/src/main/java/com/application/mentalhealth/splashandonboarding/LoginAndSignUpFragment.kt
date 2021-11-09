package com.application.mentalhealth.splashandonboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.application.mentalhealth.R
import kotlinx.android.synthetic.main.fragment_login_and_sign_up.view.*

class LoginAndSignUpFragment : Fragment(R.layout.fragment_login_and_sign_up) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginAndSignUpFragment_to_fifthScreen)
        }
    }
}