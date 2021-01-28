package com.example.apphospital

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        completar_registroDiario_btn

        completar_registroDiario_btn.setOnClickListener {
            startActivity(Intent(this,RegistroDiarioDetailsFrom::class.java))
        }

    }

}