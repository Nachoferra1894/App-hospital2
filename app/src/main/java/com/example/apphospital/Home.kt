package com.example.apphospital

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.apphospital.classes.UserClass
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var fileInputStream: FileInputStream? = null
        fileInputStream = openFileInput("user_info")
        var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
        val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder: StringBuilder = StringBuilder()
        var text: String? = null
        while ({ text = bufferedReader.readLine(); text }() != null) {
            stringBuilder.append(text)
        }

        val user:UserClass = Json.decodeFromString(stringBuilder.toString())

        Toast.makeText(this,user.fullname,Toast.LENGTH_LONG).show();

        val tv_fullname:TextView = findViewById(R.id.id_home_fullname)
        if (user.fullname.length > 0) tv_fullname.setText(user.fullname).toString() 

        val iv_avatar: ImageView = findViewById<ImageView>(R.id.id_avatar)

        iv_avatar.setOnClickListener{
            startActivity(Intent(this,SwitchAvatar::class.java))
        }

    }

}


