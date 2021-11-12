package com.application.mentalhealth.SimpleViews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.application.mentalhealth.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_discover.*

class DiscoverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover)

        setviewPagerAdaptor()
    }

    private fun setviewPagerAdaptor() {
        val pagerAdapter = ViewPager(supportFragmentManager, lifecycle)
        viewPager.setAdapter(pagerAdapter)
        TabLayoutMediator(tabLayout, viewPager
        ) { tab, position ->
            if (position == 0) {
                tab.text = "All"
            }else if (position == 1) {
                tab.text = "Read"
            }else if (position == 2) {
                tab.text = "Meditate"
            }else {
                tab.text = "Sleep"
            }
        }.attach()

    }
}