package com.example.apphospital

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.apphospital.classes.UserClass
import kotlinx.android.synthetic.main.activity_datos_del_usuario.*
import kotlinx.android.synthetic.main.activity_datos_medicos.*
import kotlinx.serialization.Serializable

class datosMedicos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_medicos)

        val nombre = intent.getStringExtra("nombre")
        val email = intent.getStringExtra("email")
        val genero = intent.getBooleanExtra("genero",true)
        val  dia =intent.getIntExtra("dia",0).toString()
        val  mes =intent.getIntExtra("mes",1).toString()
        val year = intent.getIntExtra("año",0).toString()
        val dni = intent.getStringExtra("dni")

        val medicos= resources.getStringArray(R.array.medicos)
        val adaptador = ArrayAdapter(this,R.layout.spinner_item,medicos)
        medicos_spnr.adapter=adaptador

        val lugares= resources.getStringArray(R.array.lugares)
        val adaptadorLugar = ArrayAdapter(this,R.layout.spinner_item,lugares)
        lugar_spnr.adapter=adaptadorLugar


        continue_btn_datmed.setOnClickListener {
            if(etnia_edtxt_datmed.text.isEmpty()||id_edtxt_datmed.text.isEmpty()){
                val text = "Completa todos los datos antes de seguir"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }
            else{
                val intent = Intent(this,FaltaPoco::class.java)

                val selectedMedic = medicos_spnr.selectedItemPosition.toString()
                val selectedPlace = lugar_spnr.selectedItemPosition.toString()
                val etnia = etnia_edtxt_datmed.text.toString()
                val id = id_edtxt_datmed.text.toString()

                //val user : Serializable = UserClass(nombre,dni,genero,dia+mes+year,selectedMedic,selectedPlace,etnia,id,null,null,false,false,false,false,null)

                //intent.putExtra("user",user)
                startActivity(intent)
            }
        }
    }
}