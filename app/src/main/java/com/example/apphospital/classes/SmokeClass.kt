package com.example.apphospital.classes

import kotlinx.serialization.Serializable

@Serializable
class SmokeClass {
    val option:Boolean;val quantity:String;val time:String

    constructor(option: Boolean, quantity: String="none", time: String="none") {
        this.option = option
        this.quantity = quantity
        this.time = time
    }
}
