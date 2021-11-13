package com.application.mentalhealth.SplashAndOnBoarding.login.extra

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import com.application.mentalhealth.R
import com.application.mentalhealth.SplashAndOnBoarding.login.PagerAdaptor
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_signup2.*
import android.content.Context.MODE_PRIVATE


class Login : Fragment(R.layout.fragment_login) {
    companion object {
        private val RC_SIGN_IN = 120
        private const val SHARED_PREFERENCE_KEY = "com.xyz.sharedpreferences"
    }

    private var mAuth = FirebaseAuth.getInstance()
    private var name: String = ""
    private lateinit var googleSignInClient: GoogleSignInClient
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_sign_up.setOnClickListener {
            registerNewUser()
        }

        accountpresent.setOnClickListener {
            val fragmentTransaction: FragmentTransaction? = fragmentManager?.beginTransaction()
            val signin = Signin()
            fragmentTransaction!!.replace(R.id.fragmentContainerView, signin, "signin")
                .addToBackStack("signin").commit()
        }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(activity, gso)

        google.setOnClickListener {
            signIn()
        }
    }

    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            val expection = task.exception
            if (task.isSuccessful) {

                try {
                    // Google Sign In was successful, authenticate with Firebase
                    val account = task.getResult(ApiException::class.java)!!
                    Log.d(name, "firebaseAuthWithGoogle:" + account.id)
                    firebaseAuthWithGoogle(account.idToken!!)
                } catch (e: ApiException) {
                    // Google Sign In failed, update UI appropriately
                    Log.d(name, "Google sign in failed", e)
                }
            } else {
                Log.d(name, "Google sign in failed", expection)

            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(name, "signInWithCredential:success")
                    Toast.makeText(activity,
                        "Login Successful " + mAuth.currentUser!!.displayName,
                        Toast.LENGTH_SHORT).show()

                    val sharedPreferences: SharedPreferences =
                        requireActivity().getSharedPreferences(SHARED_PREFERENCE_KEY, MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString("CustomerName", mAuth.currentUser!!.displayName)
                    editor.apply()

                    Navigation.findNavController(requireView())
                        .navigate(R.id.action_login_to_fourthScreen3)

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(name, "signInWithCredential:failure", task.exception)
                }
            }
    }


    private fun registerNewUser() {

        var userName = etusername.text.toString()
        var emailId = etemailid.text.toString().trim()

        var password = etPassword.text.toString()
        Log.d(name, emailId)
        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(context, "Please Enter the user Name ", Toast.LENGTH_SHORT).show()
            return
        }

        if (TextUtils.isEmpty(emailId)) {
            Toast.makeText(context, "Please Enter the Email-id ", Toast.LENGTH_SHORT).show()
            return
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(context, "Please Enter the password ", Toast.LENGTH_SHORT).show()
            return
        }


        mAuth.createUserWithEmailAndPassword(emailId, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    mAuth.currentUser?.sendEmailVerification()?.addOnCompleteListener {
                        Toast.makeText(activity, "Email sent for verification", Toast.LENGTH_SHORT)
                            .show()
                        if (it.isSuccessful)
                            if (mAuth.currentUser!!.isEmailVerified) {
                                Toast.makeText(
                                    context,
                                    "Registration successful!" + mAuth.currentUser!!.displayName,
                                    Toast.LENGTH_LONG
                                ).show()
                                Navigation.findNavController(requireView())
                                    .navigate(R.id.action_login_to_fourthScreen3)
                            }
                    }
                } else {
                    Toast.makeText(
                        context,
                        "Registration failed!!" + "inValid Credentials" ,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        setviewPagerAdaptor()
//
//    }
//
//    private fun setviewPagerAdaptor() {
//        val pagerAdapter = fragmentManager?.let { PagerAdaptor(it,lifecycle) }
//        viewPager.setAdapter(pagerAdapter)
//        TabLayoutMediator(tabLayout, viewPager
//        ) { tab, position ->
//            if (position == 0) {
//                tab.text = "Sign up"
//            }else {
//                tab.text = "Log In"
//            }
//        }.attach()
//    }
}