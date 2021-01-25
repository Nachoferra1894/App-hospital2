package com.example.apphospital

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv_click_me: TextView = findViewById(R.id.login_txt_register) as TextView

        tv_click_me.setOnClickListener {
            startActivity(Intent(this,datosDelUsuario::class.java))
        }
    }

}