package com.example.apphospital

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.apphospital.classes.UserClass
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    var iv_avatar:ImageView?=null
    var index:Int=0
    lateinit var user:UserClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        loadData()

        iv_avatar = findViewById<ImageView>(R.id.id_avatar)
        user.image?.let { Integer.parseInt(it) }?.let { UserImageChanger.changeAvatar(id_avatar,index) }

        val tv_fullname:TextView = findViewById(R.id.id_home_fullname)
        if (user.fullname?.length!! > 0) tv_fullname.setText(user.fullname).toString()


        iv_avatar!!.setOnClickListener{
            startActivity(Intent(this, SwitchAvatar::class.java))
        }

        completar_registroDiario_btn.setOnClickListener{
            startActivity(Intent(this, ScreenSlidePagerActivity::class.java))
        }

        completar_sintomas_btn.setOnClickListener{
            val i = Intent(this, Symptoms::class.java)
            i.putExtra("id",user.id)
            startActivity(i)
        }

        home_log_out.setOnClickListener {
            val builder = AlertDialog.Builder(this, R.style.MyDialogTheme)
                .setTitle("Log Out")
                .setMessage("Estas seguro que queres deslogearte?")
                .setPositiveButton(android.R.string.yes,DialogInterface.OnClickListener { dialog, which ->
                    ReadWriteUserData.clear(applicationContext)
                    startActivity(Intent(this, MainActivity::class.java))
                })
                .setNegativeButton(android.R.string.no,null)
                .show()

        }
        val moveUp = AnimationUtils.loadAnimation(this,R.anim.slide_up)
        homeLayout5.startAnimation(moveUp)
        homeLayout3.startAnimation(moveUp)
        homeLayout7.startAnimation(moveUp)

        homeLayout5.visibility = View.VISIBLE
        homeLayout3.visibility = View.VISIBLE
        homeLayout7.visibility= View.VISIBLE


    }

    private fun loadData(){
        user = ReadWriteUserData.read(applicationContext)
        index = user.image?.toInt() ?: 0
    }

    override fun onResume() {
        super.onResume()
        loadData()
        UserImageChanger.changeAvatar(id_avatar,index)
        val moveUp = AnimationUtils.loadAnimation(this,R.anim.slide_up)

        homeLayout5.startAnimation(moveUp)
        homeLayout3.startAnimation(moveUp)
        homeLayout7.startAnimation(moveUp)

        homeLayout5.visibility = View.VISIBLE
        homeLayout3.visibility = View.VISIBLE
        homeLayout7.visibility = View.VISIBLE

    }

    override fun onPause() {
        super.onPause()
        homeLayout5.visibility = View.INVISIBLE
        homeLayout3.visibility = View.INVISIBLE
        homeLayout7.visibility = View.INVISIBLE
    }

}


