package com.example.lesson_4_walmartlogin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.email
import kotlinx.android.synthetic.main.activity_main.password
import kotlinx.android.synthetic.main.fragment_register_activty.*

class RegisterActivty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_register_activty)

        button_create_account.setOnClickListener{register()}
    }

    private fun register() {
        val user = User(email.text.toString(),
            lastname.text.toString(),
            password.text.toString(),
            firstname.text.toString())

        if (user.firstName.isEmpty() ||
            user.lastName.isEmpty() ||
            user.userName.isEmpty() ||
            user.password.isEmpty()
        ) {
            Toast.makeText(applicationContext, "Please fill all required fields", Toast.LENGTH_SHORT).show()
            return
        }

        Toast.makeText(applicationContext, "Account created successfully", Toast.LENGTH_SHORT).show()
        val intent = Intent()
        intent.putExtra("user", user)
        setResult(RESULT_OK, intent)
        finish()
    }
}