package com.example.apphospital.classes

import kotlinx.serialization.Serializable

@Serializable
class UserClass {

    constructor(fullname: String, DNI: String, gender: Boolean, birthday: String, medic: String, place: String, etnia: String, id:String,
                smoke:SmokeClass, diabetic:DiabeticClass,Hip:Boolean,Epoc:Boolean,ACV:Boolean,HeartAttack:Boolean,registerday:String) {

    }
}