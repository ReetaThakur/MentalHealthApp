package com.application.mentalhealth

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.application.mentalhealth.adapters.PageAdapter
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var pagerAdapter:PageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavigationView.background=null
        bottomNavigationView.menu.getItem(1).isEnabled=false

        val drawerLayout: DrawerLayout =findViewById(R.id.drawerLayout)
        val navView: NavigationView =findViewById(R.id.navigationView)
        toggle= ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title="Nino"
        selectTabLayout()

    }

    private fun selectTabLayout() {

        pagerAdapter= PageAdapter(supportFragmentManager,tabLayout.tabCount)
        viewPager.apply {
            adapter=pagerAdapter
        }

        tabLayout.setOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.setCurrentItem(tab.position)

                if (tab.position==0||tab.position==1){
                    pagerAdapter.notifyDataSetChanged()
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        //it is a listner for draging the fragments, if we drag the also change tab
        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}