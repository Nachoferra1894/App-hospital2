package com.example.apphospital

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import androidx.annotation.RequiresApi
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

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, sexos)

        spinner.adapter = adaptador

        //DatePicker

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        datePicker_btn_id.setOnClickListener {
            val dpd = DatePickerDialog(this,R.style.my_dialog_theme, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                date_txtVw.setText("" + mDay + "/" + (mMonth+1) + "/" + mYear)
            }, year, month, day)
            dpd.show()
        }
    }
}