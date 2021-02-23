package com.example.apphospital

import android.widget.ImageView

class UserImageChanger {
    companion object{
        fun changeAvatar(view:ImageView,avatar:Int){
            when(avatar){
                1 -> view.setImageResource(R.drawable.avatar1)
                2 -> view.setImageResource(R.drawable.avatar2)
                3 -> view.setImageResource(R.drawable.avatar3)
                4 -> view.setImageResource(R.drawable.avatar4)
                5 -> view.setImageResource(R.drawable.avatar5)
                6 -> view.setImageResource(R.drawable.avatar6)
                7 -> view.setImageResource(R.drawable.avatar7)
                8 -> view.setImageResource(R.drawable.avatar8)
                9 -> view.setImageResource(R.drawable.avatar9)
                10 -> view.setImageResource(R.drawable.avatar10)
                11 -> view.setImageResource(R.drawable.avatar11)
                12 -> view.setImageResource(R.drawable.avatar12)
                13 -> view.setImageResource(R.drawable.avatar13)
                14 -> view.setImageResource(R.drawable.avatar14)
                15 -> view.setImageResource(R.drawable.avatar15)
                else -> view.setImageResource(R.drawable.avatar1)
            }
        }
    }
}