package com.example.apphospital

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class showExcel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_excel)

        val spinner1 = findViewById<Spinner>(R.id.spinner1)
        val listOfCodigos = arrayListOf<String>()
        val listOfMedra = arrayListOf<String>()
        val listOfCTCAE = arrayListOf<String>()
        val listOfGrado1 = arrayListOf<String>()
        val listOfGrado2 = arrayListOf<String>()
        val listOfGrado3 = arrayListOf<String>()
        val listOfGrado4 = arrayListOf<String>()
        val listOfGrado5 = arrayListOf<String>()
        val listOfNota = arrayListOf<String>()
        val listOfGradoCambio = arrayListOf<String>()



        val strings = applicationContext.assets.open("sintomas.tsv").bufferedReader().use{
            it.readLines().forEach(){
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
                listOfNota.add(lstOfMyString.get(8))
                listOfGradoCambio.add(lstOfMyString.get(9))
            }
        }


        val adaptador = ArrayAdapter(this,R.layout.spinner_item,listOfCTCAE)

        spinner1.adapter = adaptador

    }
}