package com.example.apphospital
import com.example.apphospital.*

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.apphospital.classes.UserClass
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class Home : AppCompatActivity() {
    var iv_avatar:ImageView?=null
    var index:Int=0
    lateinit var user:UserClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        loadData()

        iv_avatar = findViewById<ImageView>(R.id.id_avatar)

        Toast.makeText(applicationContext, user!!.image,Toast.LENGTH_SHORT).show();
        user.image?.let { Integer.parseInt(it) }?.let { UserImageChanger.changeAvatar(id_avatar,index) }

        val tv_fullname:TextView = findViewById(R.id.id_home_fullname)
        if (user.fullname?.length!! > 0) tv_fullname.setText(user.fullname).toString()


        iv_avatar!!.setOnClickListener{
            startActivity(Intent(this, SwitchAvatar::class.java))
        }

        completar_registroDiario_btn.setOnClickListener{
            startActivity(Intent(this, ScreenSlidePagerActivity::class.java))
        }

        home_log_out.setOnClickListener {
            val builder = AlertDialog.Builder(this)
                .setTitle("Log Out")
                .setMessage("Estas seguro que queres deslogearte?")
                .setPositiveButton(android.R.string.yes,DialogInterface.OnClickListener { dialog, which ->
                    ReadWriteUserData.clear(applicationContext)
                    startActivity(Intent(this, MainActivity::class.java))
                })
                .setNegativeButton(android.R.string.no,null)
                .show()

        }


    }

    private fun loadData(){
        user = ReadWriteUserData.read(applicationContext)
        index = user.image?.toInt() ?: 0
    }

    override fun onResume() {
        super.onResume()
        loadData()
        UserImageChanger.changeAvatar(id_avatar,index)
    }

}


