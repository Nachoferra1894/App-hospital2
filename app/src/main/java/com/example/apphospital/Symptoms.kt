package com.example.apphospital

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apphospital.classes.Symptom
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_register_details_form.*
import kotlinx.android.synthetic.main.activity_sintomas.*
import java.util.*


class Symptoms : AppCompatActivity() {

    var userId:String = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sintomas)

        userId = intent.getStringExtra("id")

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
            val anotherAdaptador = ArrayAdapter<String>(this@Symptoms, R.layout.spinner_item, listOfGradosDeUnSintoma)
            viewOfGrados.setAdapter(anotherAdaptador)
            descrption_txt.setText(listOfDefinicion[index])
        }

        btn_symptoms_confirm.setOnClickListener {
            if(!viewOfSintomas.text.isEmpty()){

                val date = Calendar.getInstance().time

                val symptom= Symptom(viewOfSintomas.text.toString(),viewOfGrados.selectedItemPosition.toString(),
                                    date.toString())

                loadingPanelSymptoms.visibility=View.VISIBLE
                val db = FirebaseFirestore.getInstance()


                val userPlace = db.collection("users").document(userId).collection("symptoms").document()
                userPlace.get()
                    .addOnSuccessListener { document ->
                        if (!document.exists()) {
                            userPlace.set(symptom)
                            val text = "Sintoma registrado exitosamente"
                            loadingPanelSymptoms.visibility=View.INVISIBLE
                            val duration = Toast.LENGTH_SHORT
                            val toast = Toast.makeText(applicationContext, text, duration)
                            toast.show()
                            startActivity(Intent(this, Home::class.java))
                            finish()
                        } else {
                            loadingPanelSymptoms.visibility=View.INVISIBLE
                            val text = "A ocurrido un error"
                            val duration = Toast.LENGTH_SHORT
                            val toast = Toast.makeText(applicationContext, text, duration)
                            toast.show()
                            startActivity(Intent(this, Home::class.java))
                            finish()
                        }
                    }
                    .addOnFailureListener { exception ->
                        loadingPanelSymptoms.visibility=View.INVISIBLE
                        val text = "A ocurrido un error"
                        val duration = Toast.LENGTH_SHORT
                        val toast = Toast.makeText(applicationContext, text, duration)
                    }

            }
        }
    }
}