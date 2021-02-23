package com.example.apphospital

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_confirm_user.*

class ConfirmUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_user)

        val name = intent.getStringExtra("name")
        val index = intent.getIntExtra("avatar",0)

        UserImageChanger.changeAvatar(confirm_avatar,index)
        confirm_name.setText(name)

        confirm_continue_text.setOnClickListener {
            startActivity(Intent(this,Home::class.java))
            finish()
        }


    }
}