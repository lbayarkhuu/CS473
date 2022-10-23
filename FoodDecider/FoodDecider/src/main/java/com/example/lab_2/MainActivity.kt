package com.example.lab_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foods = arrayListOf("Hamburger", "Pizza",
            "Mexican", "American", "Chinese")


        val decideButton =  findViewById<Button>(R.id.decideButton)
        val addFoodButton =  findViewById<Button>(R.id.addFoodButton)

        decideButton.setOnClickListener {
            textView.text = foods[Random.nextInt(0, foods.size - 1)]
        }

        addFoodButton.setOnClickListener {
            textView.text = findViewById<EditText>(R.id.addFoodInput).text
        }
    }
}