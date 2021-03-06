package com.application.mentalhealth.MyNursery

import android.animation.ObjectAnimator
import android.content.Context
import android.content.SharedPreferences
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.application.mentalhealth.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.carousel_pager.view.*
import kotlinx.android.synthetic.main.quickchallengedialogue.view.*

class CarouselPager(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attributeSet, defStyleAttr) {
    constructor(context: Context, attributeSet: AttributeSet? = null) : this(
        context,
        attributeSet,
        0
    )

    constructor(context: Context) : this(context, null)

    private val carouselPages = mutableListOf<CarouselPage>()
    private var carouselListener: CarouselListener? = null

    init {
        inflateView()
        setGifImage()
        progressbars()
    }

    private fun progressbars() {
        nruseryprogressbar.max = 10

        val sharedPreferencesprogressbar: SharedPreferences = context.getSharedPreferences("ProgressBar",
            Context.MODE_PRIVATE)
        val value = sharedPreferencesprogressbar.getInt("valueprogress",4)
        val Str = "" + value
        val currentprogress = Str.toInt()

        xpvalue.text = "" + value
        ObjectAnimator.ofInt(nruseryprogressbar, "progress", currentprogress)
            .setDuration(2000)
            .start()
    }


    private fun setGifImage() {
        Glide.with(this).asGif().load(R.raw.animated_leaves).into(iv_GifView)
    }

    fun setUpCarousel(
        fragmentActivity: FragmentActivity,
        carouselPages: List<CarouselPage>,
    ): CarouselPager {
        val viewPagerAdapter = ViewPagerAdapter(fragmentActivity)
        viewPagerAdapter.setPages(carouselPages)
        viewPager.adapter = viewPagerAdapter
        this.carouselPages.addAll(carouselPages)
        return this
    }

    fun setUpPageTransformer(pageTransformer: ViewPager2.PageTransformer): CarouselPager {
        viewPager.setPageTransformer(pageTransformer)
        return this
    }

    fun setUpCarouselListener(carouselListener: CarouselListener): CarouselPager {
        this.carouselListener = carouselListener
        return this
    }

    interface CarouselListener {
        fun onCarouselFinished(skipped: Boolean = false)
    }

    private fun inflateView() {
        View.inflate(context, R.layout.carousel_pager, this)

    }

}