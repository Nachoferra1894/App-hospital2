package com.example.apphospital

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.apphospital.classes.UserClass
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class Home : AppCompatActivity() {
    var iv_avatar:ImageView?=null
    var index:Int?=0
    lateinit var user:UserClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        user = ReadWriteUserData.read(applicationContext)
        index = user.image?.let { Integer.parseInt(it) }

        iv_avatar = findViewById<ImageView>(R.id.id_avatar)

        Toast.makeText(applicationContext, user!!.image,Toast.LENGTH_SHORT).show();
        user!!.image?.let { Integer.parseInt(it) }?.let { changeAvatar(it) }

        val tv_fullname:TextView = findViewById(R.id.id_home_fullname)
        if (user.fullname?.length!! > 0) tv_fullname.setText(user.fullname).toString()


        iv_avatar!!.setOnClickListener{
            startActivity(Intent(this,SwitchAvatar::class.java))
        }

        completar_registroDiario_btn.setOnClickListener{
            startActivity(Intent(this,ScreenSlidePagerActivity::class.java))
        }


    }

    private fun loadUser() {

    }

    private fun changeAvatar(userImage: Int) {
        when(userImage){
            1 -> iv_avatar?.setImageResource(R.drawable.avatar1)
            2 -> iv_avatar?.setImageResource(R.drawable.avatar2)
            3 -> iv_avatar?.setImageResource(R.drawable.avatar3)
            4 -> iv_avatar?.setImageResource(R.drawable.avatar4)
            5 -> iv_avatar?.setImageResource(R.drawable.avatar5)
            6 -> iv_avatar?.setImageResource(R.drawable.avatar6)
            7 -> iv_avatar?.setImageResource(R.drawable.avatar7)
            8 -> iv_avatar?.setImageResource(R.drawable.avatar8)
            9 -> iv_avatar?.setImageResource(R.drawable.avatar9)
            10 -> iv_avatar?.setImageResource(R.drawable.avatar10)
            11 -> iv_avatar?.setImageResource(R.drawable.avatar11)
            12 -> iv_avatar?.setImageResource(R.drawable.avatar12)
            13 -> iv_avatar?.setImageResource(R.drawable.avatar13)
            14 -> iv_avatar?.setImageResource(R.drawable.avatar14)
            15 -> iv_avatar?.setImageResource(R.drawable.avatar15)
            else -> iv_avatar?.setImageResource(R.drawable.avatar1)
        }
    }

    override fun onStart() {
        super.onStart()
        loadUser()
        changeAvatar(index!!)
        Toast.makeText(applicationContext,"Start " + Integer.toString(index!!),Toast.LENGTH_SHORT).show()
    }


}


