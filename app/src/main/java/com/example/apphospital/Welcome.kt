package com.example.apphospital

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_welcome.*

class Welcome:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val user = ReadWriteUserData.read(applicationContext)
        val index = user.image?.toInt() ?: 0

        UserImageChanger.changeAvatar(welcome_avatar,index)

        welcome_title_first.setText(getFirstName(user.fullname))
        welcome_name_full.setText(user.fullname)

        wlecome_confirm.setOnClickListener {
            val i = Intent(this,ConfirmUser::class.java)
            i.putExtra("name",user.fullname)
            i.putExtra("avatar",index)
            startActivity(i)
            finish()
        }
        welcome_negate.setOnClickListener {
            ReadWriteUserData.clear(applicationContext)
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
    fun getFirstName(fullname:String?):String{
        if(fullname != null) {
            var index = fullname.indexOf(' ')
            return (if (index >= 0) fullname.substring(0, index) else fullname)
        }else{
            return("")
        }
    }
}