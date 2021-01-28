package com.example.apphospital.classes

import kotlinx.serialization.Serializable

@Serializable
class UserClass(val fullname: String,val DNI: String,val gender: Boolean,val birthday: String,val medic: String,val place: String,val etnia: String,val id:String,
var smoke:SmokeClass?,var diabetic:DiabeticClass?,var hip:Boolean,var epoc:Boolean,var acv:Boolean,var heartAttack:Boolean,var registerday:String?){



}