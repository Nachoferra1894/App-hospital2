package com.example.apphospital

import android.content.Context
import com.example.apphospital.classes.UserClass
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

class ReadWriteUserData {

    companion object{

        fun write(user:UserClass , context: Context){
            val jsonList = Json.encodeToJsonElement(user)
            val file:String = "user_info"
            val data:String = jsonList.toString()
            val fileOutputStream: FileOutputStream
            try {
                fileOutputStream = context.openFileOutput(file, Context.MODE_PRIVATE)
                fileOutputStream.write(data.toByteArray())
            }catch (e: Exception){
                println("explosion")
            }
        }

        fun read(context: Context): UserClass {
            var fileInputStream: FileInputStream? = null
            fileInputStream = context.openFileInput("user_info")
            var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder: StringBuilder = StringBuilder()
            var text: String? = null
            while ({ text = bufferedReader.readLine(); text }() != null) {
                stringBuilder.append(text)
            }
            if(text == null){
                throw noUserLocalMemoryExeption()
            }

            return Json.decodeFromString(stringBuilder.toString())
        }

    }

}