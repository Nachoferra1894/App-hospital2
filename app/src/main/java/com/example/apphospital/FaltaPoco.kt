package com.example.apphospital

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_datos_medicos.*
import kotlinx.android.synthetic.main.activity_faltapoco.*
import kotlinx.android.synthetic.main.activity_main.*

class FaltaPoco :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faltapoco)

        val user = intent.getSerializableExtra("user")

        continue_txt_faltapoco.setOnClickListener {
            val intent = Intent(this,RegisterDetailsForm::class.java)
            intent.putExtra("user",user)
            startActivity(intent)
        }
    }

}