package com.example.apphospital

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_terminamos.*

class Terminamos: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terminamos)

        btn_terminamos.setOnClickListener {
            startActivity(Intent(this,Home::class.java))
        }
    }
}