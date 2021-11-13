package com.application.mentalhealth.MyNursery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.application.mentalhealth.R
import kotlinx.android.synthetic.main.activity_nursery.*

class NurseryActivity : AppCompatActivity(), CarouselPager.CarouselListener {

    private val carouselPages = listOf(
        CarouselPage(R.drawable.ic_zamia,R.string.title1, R.string.text1),
        CarouselPage(R.drawable.ic_monstera,R.string.title1, R.string.text1),
        CarouselPage(R.drawable.ic_agiaonema,R.string.title1, R.string.text1),
        CarouselPage(R.drawable.ic_seed,R.string.title1, R.string.text1)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nursery)

        carouselPager
            .setUpCarousel(this, carouselPages)
            .setUpPageTransformer(ZoomOutPageTransformer())
            .setUpCarouselListener(this)
    }

    override fun onCarouselFinished(skipped: Boolean) {
        val carouselStatus = if (skipped) "skipped" else "completed"
        Toast.makeText(this, "You've $carouselStatus the on boarding.", Toast.LENGTH_SHORT).show()
    }
}