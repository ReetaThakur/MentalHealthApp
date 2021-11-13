package com.application.mentalhealth.MyNursery

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.application.mentalhealth.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.dialogue_showing_plant_desc_mynursery.view.*
import kotlinx.android.synthetic.main.fragment_carousel_page.*

class CarouselPageFragment(private val page: CarouselPage) : Fragment(R.layout.fragment_carousel_page) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carouselPageImage.setImageResource(page.image)
        carouselPageTitle.setText(page.title)
        carouselPageText.setText(page.text)
        btnLiveHelp_MyNursery.setOnClickListener {
            val view = View.inflate(context, R.layout.dialogue_showing_plant_desc_mynursery, null)

            val builder = context?.let { it1 -> AlertDialog.Builder(it1) }
            builder?.setView(view)

            val dialog = builder?.create()

            dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog?.show()
            //     dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog?.setCancelable(false)
            view.btn_cancel_Dialogue_MyNursery.setOnClickListener {
                dialog?.dismiss()
            }
            Glide.with(this).asGif().load(R.raw.monsteraplantprogress).into(view.iv_Dialogue_MyNurseryGif)
        }
    }
}