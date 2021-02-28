package com.example.apphospital

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sintomas.*
import java.util.*


class showExcel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sintomas)

        val viewOfSintomas = findViewById<AutoCompleteTextView>(R.id.autoView1)
        val viewOfGrados = findViewById<Spinner>(R.id.autoView2)

        val listOfCodigos = arrayListOf<String>()
        val listOfMedra = arrayListOf<String>()
        val listOfCTCAE = arrayListOf<String>()
        val listOfGrado1 = arrayListOf<String>()
        val listOfGrado2 = arrayListOf<String>()
        val listOfGrado3 = arrayListOf<String>()
        val listOfGrado4 = arrayListOf<String>()
        val listOfGrado5 = arrayListOf<String>()
        val listOfDefinicion = arrayListOf<String>()
        val listOfNota = arrayListOf<String>()
        val listOfGradoCambio = arrayListOf<String>()
        val listOfGradosDeUnSintoma = arrayListOf<String>()


        val strings = applicationContext.assets.open("sintomas.tsv").bufferedReader().use {
            it.readLines().forEach() {
                val myString = it
                val lstOfMyString = myString.split("\t").toTypedArray()
                listOfCodigos.add(lstOfMyString.get(0))
                listOfMedra.add(lstOfMyString.get(1))
                listOfCTCAE.add(lstOfMyString.get(2))
                listOfGrado1.add(lstOfMyString.get(3))
                listOfGrado2.add(lstOfMyString.get(4))
                listOfGrado3.add(lstOfMyString.get(5))
                listOfGrado4.add(lstOfMyString.get(6))
                listOfGrado5.add(lstOfMyString.get(7))
                listOfDefinicion.add(lstOfMyString.get(8))
                listOfNota.add(lstOfMyString.get(9))
                listOfGradoCambio.add(lstOfMyString.get(10))
            }
        }


        val adaptador =
            ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, listOfCTCAE)

        viewOfSintomas.setAdapter(adaptador)

        viewOfSintomas.setOnItemClickListener { parent, view, position, id ->
            listOfGradosDeUnSintoma.clear()
            val nameOfSintoma = viewOfSintomas.text
            val index = listOfCTCAE.indexOf(nameOfSintoma.toString())

            listOfGradosDeUnSintoma.add(listOfGrado1[index])
            listOfGradosDeUnSintoma.add(listOfGrado2[index])
            listOfGradosDeUnSintoma.add(listOfGrado3[index])
            listOfGradosDeUnSintoma.add(listOfGrado4[index])
            listOfGradosDeUnSintoma.add(listOfGrado5[index])
            val anotherAdaptador = ArrayAdapter<String>(this@showExcel, R.layout.spinner_item, listOfGradosDeUnSintoma)
            viewOfGrados.setAdapter(anotherAdaptador)
            descrption_txt.setText(listOfDefinicion[index])
        }
    }
}