package com.application.mentalhealth.SplashAndOnBoarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.application.mentalhealth.R
import kotlinx.android.synthetic.main.fragment_login_and_sign_up.view.*

class LoginAndSignUpFragment : Fragment(R.layout.fragment_login_and_sign_up) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.btnLogin.setOnClickListener {
//            findNavController().navigate(R.id.action_loginAndSignUpFragment_to_fourthScreen)
        }
    }
}