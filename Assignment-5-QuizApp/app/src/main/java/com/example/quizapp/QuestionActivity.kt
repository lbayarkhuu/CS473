package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.data.QuestionListDatabase
import kotlinx.android.synthetic.main.activity_main.*

class QuestionActivity : AppCompatActivity() {
    private var questionDatabase: QuestionListDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionDatabase = QuestionListDatabase.getInstance(this)

    }
}