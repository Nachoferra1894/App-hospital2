package com.example.apphospital

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_datos_del_usuario.*

class datosDelUsuario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_del_usuario)

        val spinner = findViewById<Spinner>(R.id.sexos_spnr)

        val sexos = resources.getStringArray(R.array.sexos)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, sexos)

        spinner.adapter = adaptador

    }
}