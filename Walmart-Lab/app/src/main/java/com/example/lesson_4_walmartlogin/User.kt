package com.example.lesson_4_walmartlogin
import java.io.Serializable;

class User(
    var firstName: String = "",
    var lastName: String = "",
    var userName: String = "",
    var password: String = ""
) : Serializable {}