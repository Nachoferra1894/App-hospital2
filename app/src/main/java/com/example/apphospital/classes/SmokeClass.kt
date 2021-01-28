package com.example.apphospital.classes

import kotlinx.serialization.Serializable


@Serializable
data class SmokeClass constructor(var option:Boolean, var quantity:String,var time:String){

}
