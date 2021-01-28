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

        login_txt_register.setOnClickListener {
            startActivity(Intent(this,datosDelUsuario::class.java))
        }

        login_btn_login.setOnClickListener {
            startActivity(Intent(this,Home::class.java))
        }
    }

}