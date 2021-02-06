package com.example.apphospital.classes

import kotlinx.serialization.Serializable

@Serializable
class DiabeticClass {
    val option:Boolean;val medication:String?

    constructor(option: Boolean, medication: String?="none") {
        this.option = option
        this.medication = medication
    }
}
