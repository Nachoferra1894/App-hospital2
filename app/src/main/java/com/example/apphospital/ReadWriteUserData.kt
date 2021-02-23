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
            val file = "user_info"
            val data:String = jsonList.toString()
            val fileOutputStream: FileOutputStream
            try {
                fileOutputStream = context.openFileOutput(file, Context.MODE_PRIVATE)
                fileOutputStream.write(data.toByteArray())
                fileOutputStream.close()
            }catch (e: Exception){
                println("explosion")
            }
        }

        fun read(context: Context): UserClass {
            var fileInputStream = context.openFileInput("user_info")
            var inputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder: StringBuilder = StringBuilder()
            var text: String? = null
            while ({ text = bufferedReader.readLine(); text }() != null) {
                stringBuilder.append(text)
            }

            fileInputStream.close()
            return Json.decodeFromString(stringBuilder.toString())
        }

        fun clear(context: Context){
            context.deleteFile("user_info")
        }

    }

}