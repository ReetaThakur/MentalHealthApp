package com.application.mentalhealth.SimpleViews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.application.mentalhealth.R
import com.application.mentalhealth.botchat.BotActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        Glide.with(this).asGif().load(R.raw.let_us_chat).into(ivChatGifView)

        llayout.setOnClickListener{
            val intent : Intent = Intent(this,BotActivity::class.java)
            startActivity(intent)
        }
    }
}