package com.application.mentalhealth.SimpleViews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.application.mentalhealth.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        Glide.with(this).asGif().load(R.raw.let_us_chat).into(ivChatGifView)
    }
}