package com.application.mentalhealth

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.view.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.application.mentalhealth.SimpleViews.DiscoverActivity
import com.application.mentalhealth.HomeFragment.adapters.PageAdapter
import com.application.mentalhealth.SimpleViews.chatActivity

import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import kotlinx.android.synthetic.main.acceptchallengedialgoue.view.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.quickchallengedialogue.view.*

class HomeActivity : AppCompatActivity() {


    lateinit var toggle: ActionBarDrawerToggle
    lateinit var pagerAdapter: PageAdapter
    var i = 1
    var j = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(1).isEnabled = false

        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.navigationView)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Nino"
        selectTabLayout()


        ivmenu.setOnClickListener {
            drawerLayout.openDrawer(navigationView)
        }


        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setupBottomNavigationBar()
                R.id.msg -> setupchatActivity()

            }
            true
        }
        btnRefresh.setOnClickListener {
            challenge()
        }

    }

    private fun setupchatActivity() {
        val intent: Intent = Intent(this,chatActivity::class.java)
        startActivity(intent)
    }


    private fun setupBottomNavigationBar() {
        val intent: Intent = Intent(this, DiscoverActivity::class.java)
        startActivity(intent)
    }

    private fun challenge() {

        val mDialog = LayoutInflater.from(this).inflate(R.layout.quickchallengedialogue, null)
        val mBuilder = AlertDialog.Builder(this).setView(mDialog)
        val mAlertDialog = mBuilder.show()

        mAlertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        mDialog.anotherchallenge.setOnClickListener {

            mDialog.progressbar.visibility = View.VISIBLE
            mDialog.challenge1.visibility = View.INVISIBLE
            mDialog.challenge2.visibility = View.INVISIBLE

            val handler: Handler = Handler()

            handler.postDelayed(Runnable {
                kotlin.run { mDialog.progressbar.visibility = View.INVISIBLE }
            }, 2000)


            i++;
            if (i % 2 == 0) {
                handler.postDelayed(Runnable {
                    kotlin.run {
                        mDialog.challenge1.visibility = View.INVISIBLE
                        mDialog.challenge2.visibility = View.VISIBLE
                    }
                }, 2000)

            } else {
                handler.postDelayed(Runnable {
                    kotlin.run {
                        mDialog.challenge1.visibility = View.VISIBLE
                        mDialog.challenge2.visibility = View.INVISIBLE
                    }
                }, 2000)
            }
        }

        mDialog.acceptButton.setOnClickListener {
            acceptchallenge()
            mAlertDialog.dismiss()
        }
        mDialog.declineButton.setOnClickListener {
            mAlertDialog.dismiss()
        }
    }

    private fun acceptchallenge() {
        val mDialog = LayoutInflater.from(this).inflate(R.layout.quickchallengedialogue, null)
        val cDialog = LayoutInflater.from(this).inflate(R.layout.acceptchallengedialgoue, null)
        val cBuilder = AlertDialog.Builder(this).setView(cDialog)
        val cAlertDialog = cBuilder.show()
        cAlertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        cDialog.challengeCompleted.setOnClickListener {
            j++;
            cDialog.ChallengeDone.visibility = View.VISIBLE
            cDialog.wishtext.visibility = View.VISIBLE
            cDialog.challengeCompleted.visibility = View.INVISIBLE
            cDialog.challengeaccepted1.visibility = View.INVISIBLE
            cDialog.challengeaccepted2.visibility = View.INVISIBLE
            cDialog.textaccepted.visibility = View.INVISIBLE
            cDialog.congrats.visibility = View.VISIBLE

        }

        cDialog.ChallengeDone.setOnClickListener {
            cAlertDialog.dismiss()
            challengetext.setText("$j Completed today")
            challengetext.visibility = View.VISIBLE

        }
        if (i % 2 == 0) {
            cDialog.challengeaccepted1.visibility = View.INVISIBLE
            cDialog.challengeaccepted2.visibility = View.VISIBLE
        } else {
            cDialog.challengeaccepted1.visibility = View.VISIBLE
            cDialog.challengeaccepted2.visibility = View.INVISIBLE
        }
    }

    private fun selectTabLayout() {

        pagerAdapter = PageAdapter(supportFragmentManager, tabLayout.tabCount)
        viewPager.apply {
            adapter = pagerAdapter
        }

        tabLayout.setOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.setCurrentItem(tab.position)

                if (tab.position == 0 || tab.position == 1) {
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
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}