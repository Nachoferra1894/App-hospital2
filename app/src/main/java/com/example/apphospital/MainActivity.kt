package com.example.apphospital

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.apphospital.classes.DiabeticClass
import com.example.apphospital.classes.SmokeClass
import com.example.apphospital.classes.UserClass
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import java.io.FileNotFoundException
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            val user = ReadWriteUserData.read(this)
            startActivity(Intent(this, Home::class.java))
        } catch (e: FileNotFoundException){
        }


        login_txt_register.setOnClickListener {
            startActivity(Intent(this,datosDelUsuario::class.java))
        }



        login_btn_login.setOnClickListener {
            if(login_edtxt_id.text.isEmpty() || login_edtxt_password.text.isEmpty()){
                val text = "Completa todos los datos antes de seguir"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }
            else{

                loadingPanelLogin.visibility = View.VISIBLE
                loadingPanelLogin.bringToFront()


                val db = FirebaseFirestore.getInstance()

                val id = login_edtxt_id.text.toString()

                val userPlace = db.collection("users").document(id)
                userPlace.get()

                        .addOnSuccessListener {document ->
                            if(document.exists()){

                                val userLoaded = UserClass(document.getString("fullname"),
                                document.getString("dni"),document.getBoolean("gender"),
                                document.getString("birthday"),document.getString("medic"),
                                document.getString("place"),
                                document.getString("etnia"),
                                document.getString("id"),
                                document.get<SmokeClass>("smoke",SmokeClass::class.java),
                                document.get<DiabeticClass>("diabetic",DiabeticClass::class.java),document.getBoolean("hip"),
                                document.getBoolean("epoc"),document.getBoolean("acv"),
                                document.getBoolean("heartAttack"),document.getString("registerDay"),
                                document.getString("image"))

                                ReadWriteUserData.write(userLoaded,applicationContext)
                                loadingPanelLogin.visibility = View.INVISIBLE
                                startActivity(Intent(this, Home::class.java))
                                //TODO chequear cotra y bajar usuario

                            }
                            else{
                                loadingPanelLogin.visibility = View.INVISIBLE

                                val text = "Usuario no existe"
                                val duration = Toast.LENGTH_SHORT
                                val toast = Toast.makeText(applicationContext, text, duration)
                            }
                        }
            }
        }
    }

}