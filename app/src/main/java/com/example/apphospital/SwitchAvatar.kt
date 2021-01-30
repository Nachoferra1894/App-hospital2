package com.example.apphospital

import android.content.Context
import android.media.Image
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.apphospital.classes.UserClass
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.lang.NumberFormatException

class SwitchAvatar : AppCompatActivity(){
    var user_image:Int = 0;
    var user_avatar:ImageView? = null
    var avatar_array:MutableList<ImageView>? = null
    var user: UserClass?=null
    var index:Int?=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_switch_avatar)

        getData()
        user_avatar = findViewById(R.id.id_user_avatar)
        changeAvatar(user_image)

        val iv_avatar1:ImageView = findViewById(R.id.id_avatar1)
        val iv_avatar2:ImageView = findViewById(R.id.id_avatar2)
        val iv_avatar3:ImageView = findViewById(R.id.id_avatar3)
        val iv_avatar4:ImageView = findViewById(R.id.id_avatar4)
        val iv_avatar5:ImageView = findViewById(R.id.id_avatar5)
        val iv_avatar6:ImageView = findViewById(R.id.id_avatar6)
        val iv_avatar7:ImageView = findViewById(R.id.id_avatar7)
        val iv_avatar8:ImageView = findViewById(R.id.id_avatar8)
        val iv_avatar9:ImageView = findViewById(R.id.id_avatar9)
        val iv_avatar10:ImageView = findViewById(R.id.id_avatar10)
        val iv_avatar11:ImageView = findViewById(R.id.id_avatar11)
        val iv_avatar12:ImageView = findViewById(R.id.id_avatar12)
        val iv_avatar13:ImageView = findViewById(R.id.id_avatar13)
        val iv_avatar14:ImageView = findViewById(R.id.id_avatar14)
        val iv_avatar15:ImageView = findViewById(R.id.id_avatar15)

        avatar_array = mutableListOf<ImageView>(iv_avatar1,iv_avatar2,iv_avatar3,iv_avatar4,iv_avatar5,iv_avatar6,
        iv_avatar7,iv_avatar8,iv_avatar9,iv_avatar10,iv_avatar11,iv_avatar12,iv_avatar13,iv_avatar14,iv_avatar15)


        iv_avatar1.setOnClickListener{
            changeAvatar(1)
            changeSize(1)
            index = 1
        }
        iv_avatar2.setOnClickListener{
            changeAvatar(2)
            changeSize(2)
            index = 2
        }
        iv_avatar3.setOnClickListener{
            changeAvatar(3)
            changeSize(3)
            index = 3
        }
        iv_avatar4.setOnClickListener{
            changeAvatar(4)
            changeSize(4)
            index = 4
        }
        iv_avatar5.setOnClickListener{
            changeAvatar(5)
            changeSize(5)
            index = 5
        }
        iv_avatar6.setOnClickListener{
            changeAvatar(6)
            changeSize(6)
            index = 6
        }
        iv_avatar7.setOnClickListener{
            changeAvatar(7)
            changeSize(7)
            index = 7
        }
        iv_avatar8.setOnClickListener{
            changeAvatar(8)
            changeSize(8)
            index = 8
        }
        iv_avatar9.setOnClickListener{
            changeAvatar(9)
            changeSize(9)
            index = 9
        }
        iv_avatar10.setOnClickListener{
            changeAvatar(10)
            changeSize(10)
            index = 10
        }
        iv_avatar11.setOnClickListener{
            changeAvatar(11)
            changeSize(11)
            index = 11
        }
        iv_avatar12.setOnClickListener{
            changeAvatar(12)
            changeSize(12)
            index = 12
        }
        iv_avatar13.setOnClickListener{
            changeAvatar(13)
            changeSize(13)
            index = 13
        }
        iv_avatar14.setOnClickListener{
            changeAvatar(14)
            changeSize(14)
            index = 14
        }
        iv_avatar15.setOnClickListener{
            changeAvatar(15)
            changeSize(15)
            index = 15
        }

        val btn_switch:Button = findViewById(R.id.id_avatar_btn)
        btn_switch.setOnClickListener {
            user!!.image= Integer.toString(index!!)
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
            Toast.makeText(applicationContext,"Cambio de avatar exitoso!",Toast.LENGTH_SHORT).show()
        }

    }

    private fun changeSize(i: Int) {
        var index:Int = 1;
        for (item: ImageView in avatar_array!!){
            if(i == index){
                item.layoutParams.height=260
                item.layoutParams.width=260
            }else{
                item.layoutParams.height=220
                item.layoutParams.width=220

            }

            index++
        }

    }


    private fun changeAvatar(userImage: Int) {
        when(userImage){
            1 -> user_avatar?.setImageResource(R.drawable.avatar1)
            2 -> user_avatar?.setImageResource(R.drawable.avatar2)
            3 -> user_avatar?.setImageResource(R.drawable.avatar3)
            4 -> user_avatar?.setImageResource(R.drawable.avatar4)
            5 -> user_avatar?.setImageResource(R.drawable.avatar5)
            6 -> user_avatar?.setImageResource(R.drawable.avatar6)
            7 -> user_avatar?.setImageResource(R.drawable.avatar7)
            8 -> user_avatar?.setImageResource(R.drawable.avatar8)
            9 -> user_avatar?.setImageResource(R.drawable.avatar9)
            10 -> user_avatar?.setImageResource(R.drawable.avatar10)
            11 -> user_avatar?.setImageResource(R.drawable.avatar11)
            12 -> user_avatar?.setImageResource(R.drawable.avatar12)
            13 -> user_avatar?.setImageResource(R.drawable.avatar13)
            14 -> user_avatar?.setImageResource(R.drawable.avatar14)
            15 -> user_avatar?.setImageResource(R.drawable.avatar15)
            else -> user_avatar?.setImageResource(R.drawable.avatar1)
        }
    }

    private fun getData() {
        var fileInputStream: FileInputStream? = null
        fileInputStream = openFileInput("user_info")
        var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
        val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder: StringBuilder = StringBuilder()
        var text: String? = null
        while ({ text = bufferedReader.readLine(); text }() != null) {
            stringBuilder.append(text)
        }

        user = Json.decodeFromString(stringBuilder.toString())

        user_image = Integer.parseInt(user!!.image)

    }
}