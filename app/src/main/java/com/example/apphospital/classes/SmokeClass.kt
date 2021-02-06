package com.example.apphospital.classes

import kotlinx.serialization.Serializable

@Serializable
class SmokeClass {
    val option:String;val quantity:String;val time:String

    constructor(option: String, quantity: String="none", time: String="none") {
        this.option = option
        this.quantity = quantity
        this.time = time
    }
}
