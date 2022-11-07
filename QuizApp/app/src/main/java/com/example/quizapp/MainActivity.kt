package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submit.setOnClickListener {
            var score = 0
            if (option13.isChecked) {
                score += 50
            }
            if (option22.isChecked) {
                score += 50
            }

            AlertDialog
                .Builder(this)
                .setTitle("Congratulations!")
                .setMessage("Submitted on:${Date()}. " +
                    "Your score: ${score}.")
                .create()
                .show()
        }

        reset.setOnClickListener {
            group1.clearCheck()
            group2.clearCheck()

            option11.isChecked = false;
            option12.isChecked = false;
            option13.isChecked = false;

            option21.isChecked = false;
            option22.isChecked = false;
            option23.isChecked = false;
        }
    }
}