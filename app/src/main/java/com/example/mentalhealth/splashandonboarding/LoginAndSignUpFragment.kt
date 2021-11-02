package com.example.mentalhealth.splashandonboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.mentalhealth.R
import kotlinx.android.synthetic.main.fragment_login_and_sign_up.view.*

class LoginAndSignUpFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login_and_sign_up, container, false)

        val viewPager =  activity?.findViewById<ViewPager2>(R.id.viewPager)

        view.btnLogin.setOnClickListener {
            viewPager?.currentItem = 4
        }
        return view
    }
}