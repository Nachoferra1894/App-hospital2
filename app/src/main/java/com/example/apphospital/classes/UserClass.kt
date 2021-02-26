package com.example.apphospital.classes

import kotlinx.serialization.Serializable

@Serializable
class UserClass {

    val fullname: String?; val DNI: String?; val gender: Boolean?; val birthday: String?;val medic: String?;val place: String?;val etnia: String?;
    val id:String?; val smoke:SmokeClass?;val diabetic:DiabeticClass?;
    val Hip:Boolean?;val Epoc:Boolean?;val ACV:Boolean?; val HeartAttack:Boolean?;val registerday:String?;
    var image:String?;

    constructor(
        fullname: String?,
        DNI: String?,
        gender: Boolean?,
        birthday: String?,
        medic: String?,
        place: String?,
        etnia: String?,
        id: String?,
        smoke: SmokeClass?,
        diabetic: DiabeticClass?,
        Hip: Boolean?,
        Epoc: Boolean?,
        ACV: Boolean?,
        HeartAttack: Boolean?,
        registerday: String?,
        image: String?
    ) {
        this.fullname = fullname
        this.DNI = DNI
        this.gender = gender
        this.birthday = birthday
        this.medic = medic
        this.place = place
        this.etnia = etnia
        this.id = id
        this.smoke = smoke
        this.diabetic = diabetic
        this.Hip = Hip
        this.Epoc = Epoc
        this.ACV = ACV
        this.HeartAttack = HeartAttack
        this.registerday = registerday
        this.image = image
    }


}