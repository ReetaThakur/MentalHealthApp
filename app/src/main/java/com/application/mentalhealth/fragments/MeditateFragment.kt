package com.application.mentalhealth.fragments

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.application.mentalhealth.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_meditate.*
import kotlinx.android.synthetic.main.meditatedialgoue.view.*


class MeditateFragment : Fragment(R.layout.fragment_meditate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        testing.setOnClickListener {
            dialgoue()
        }

        Glide.with(imaggif).load(R.raw.splash).into(imaggif)
    }

    private fun dialgoue() {
        val mDialog = LayoutInflater.from(context).inflate(R.layout.meditatedialgoue, null)
        val mBuilder = AlertDialog.Builder(activity).setView(mDialog)
        val mAlertDialog = mBuilder.show()

        mAlertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        mDialog.btnclose.setOnClickListener {
            mAlertDialog.dismiss()
        }
    }

}