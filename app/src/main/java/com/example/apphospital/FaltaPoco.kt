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

        val nombre = intent.getStringExtra("nombre")
        val email = intent.getStringExtra("email")
        val genero = intent.getBooleanExtra("genero",true)
        val  date =intent.getStringExtra("date")
        val dni = intent.getStringExtra("dni")
        val medic = intent.getStringExtra("medic")
        val place = intent.getStringExtra("place")
        val etnia = intent.getStringExtra("etnia")
        val id = intent.getStringExtra("id")


        continue_txt_faltapoco.setOnClickListener {
            val intent = Intent(this,RegisterDetailsForm::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("email", email)
            intent.putExtra("genero", genero)
            intent.putExtra("date", date)
            intent.putExtra("dni",dni)
            intent.putExtra("medic",medic)
            intent.putExtra("place",place)
            intent.putExtra("etnia",etnia)
            intent.putExtra("id",id)
            startActivity(intent)
        }
    }

}