package com.example.mvpwithadapter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvpwithadapter.R
import kotlinx.android.synthetic.main.activity_display.*

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        var number = intent.getStringExtra("message")

        tv_numbers.text = number
    }
}
