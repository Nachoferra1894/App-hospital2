package com.example.apphospital

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.apphospital.classes.DiabeticClass
import com.example.apphospital.classes.SmokeClass
import com.example.apphospital.classes.UserClass
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user:UserClass = UserClass("Fabrizio","123",true,"11/04/01","Carmen","Austral",
        "Blanco","10", SmokeClass(false,"1","1"), DiabeticClass(false,"no"),
        false,false,false,false,"april","1")

        val jsonList = Json.encodeToJsonElement(user)
        val file:String = "user_info"
        val data:String = jsonList.toString()
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
        }catch (e: Exception){
            e.printStackTrace()
        }


        val tv_click_me: TextView = findViewById<TextView>(R.id.login_txt_register)

        tv_click_me.setOnClickListener {
            startActivity(Intent(this,datosDelUsuario::class.java))
        }



        login_btn_login.setOnClickListener {
            startActivity(Intent(this,Home::class.java))
        }
    }

}