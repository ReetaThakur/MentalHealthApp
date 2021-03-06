package com.application.mentalhealth.SplashAndOnBoarding.login

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.application.mentalhealth.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login2.*


class LoginFragment2 : Fragment(R.layout.fragment_login2) {
    private val mAuth = FirebaseAuth.getInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnlogin.setOnClickListener {
            loginuserAccount()
        }
    }

    private fun loginuserAccount() {
        var emailid = loginemailid.text.toString()
        var password = loginpassword.text.toString()

        if (TextUtils.isEmpty(emailid)) {
            Toast.makeText(context, "Please enter email!!", Toast.LENGTH_LONG).show()
            return
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(context, "Please enter password!!", Toast.LENGTH_LONG).show()
            return
        }

        mAuth.signInWithEmailAndPassword(emailid, password)
            .addOnCompleteListener {

                if (it.isSuccessful) {
                    Toast.makeText(
                        context,
                        "Login successful!!" + mAuth.currentUser!!.email, Toast.LENGTH_LONG).show()
                    Navigation.findNavController(requireView())
                        .navigate(R.id.action_loginFragment2_to_fifthScreen2)
                } else {

                    Toast.makeText(context, "inValid Credentials ", Toast.LENGTH_LONG).show()
                }
            }
    }
}