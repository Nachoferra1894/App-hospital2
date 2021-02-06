package com.example.apphospital

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_datos_del_usuario.*
import java.util.*

class datosDelUsuario : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_del_usuario)

        //Spinner

        val spinner = findViewById<Spinner>(R.id.sexos_spnr)

        val sexos = resources.getStringArray(R.array.sexos)

        val adaptador = ArrayAdapter(this,R.layout.spinner_item,sexos)

        spinner.adapter = adaptador

        //DatePicker

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        var yearSelected: Int = 0
        var monthSelected: Int = 0
        var daySelected: Int = 0


        datePicker_btn_id.setOnClickListener {
            val dpd = DatePickerDialog(this,R.style.my_dialog_theme, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                daySelected = mDay
                monthSelected = mMonth+1
                yearSelected = mYear
                date_txtVw.setText("" + daySelected + "/" + (monthSelected+1) + "/" + yearSelected)
            }, year, month, day)
            dpd.show()
        }

        login_btn_login2.setOnClickListener {
            if (nombreYApellido_edtxt_id.text.isEmpty() || email_edtxt_id.text.isEmpty() || date_txtVw.text.isEmpty()) {
                val text = "Completa todos los datos antes de seguir"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            } else {
                val intent = Intent(this,datosMedicos::class.java)

                intent.putExtra("name", nombreYApellido_edtxt_id.text.toString())
                intent.putExtra("email", email_edtxt_id.text.toString())
                val isMale = sexos_spnr.selectedItemPosition == 0
                intent.putExtra("genero", isMale)
                intent.putExtra("dia", daySelected)
                intent.putExtra("mes", monthSelected)
                intent.putExtra("año", yearSelected)
                intent.putExtra("dni",dni_edtxt_id.text.toString())

                startActivity(intent)
            }
        }
    }
}