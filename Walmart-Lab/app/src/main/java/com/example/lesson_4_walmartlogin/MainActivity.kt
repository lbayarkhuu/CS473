package com.example.lesson_4_walmartlogin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var users: HashMap<String, User> = HashMap<String, User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        users.put("l.bayarkhuu@gmail.com", User(
            "Bayarkhuu",
            "Lodoidamba",
                    "l.bayarkhuu@gmail.com",
            "1234"
        ))
        users.put("test@gmail.com", User(
            "test",
            "user",
            "test@gmail.com",
            "qwer"
        ))

        create_account_button.setOnClickListener {
            val signUpIntent = Intent(this, RegisterActivty::class.java)
            resultLauncher.launch(signUpIntent)
        }

        sign_in.setOnClickListener {
            if (isValidated(email.text.toString(), password.text.toString())) {
                val shoppingIntent = Intent(this, ShoppingCategory::class.java)
                shoppingIntent.putExtra("email", email.text.toString())
                startActivity(shoppingIntent)
            } else {
                Toast.makeText(applicationContext, "Wrong credential", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun isValidated(email: String, password: String): Boolean {
        if (email in users.keys && users[email]?.password == password) {
            return true
        }
        return false
    }

    private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val serUser = data!!.getSerializableExtra("user")
            val newUser = serUser as User
            users.set(newUser.userName, newUser)
        }
    }
}