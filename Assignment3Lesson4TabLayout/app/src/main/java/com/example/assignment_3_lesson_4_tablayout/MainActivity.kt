package com.example.assignment_3_lesson_4_tablayout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.WARN
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val backgroundColor = Color.parseColor("#ffc0cb")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun addRow(first: String, second: String) {
            val tableRow = TableRow(applicationContext)
            val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
            tableRow.layoutParams = layoutParams

            val columnOne = TextView(this)
            columnOne.text = first
            columnOne.width = 500
            columnOne.setBackgroundColor(backgroundColor)

            val columnTwo = TextView(this)
            columnTwo.text = second
            columnTwo.width = 500
            columnTwo.setBackgroundColor(backgroundColor)

            tableRow.addView(columnOne)
            tableRow.addView(columnTwo)
            tableRow.setPadding(10, 0, 0, 10)

            table.addView(tableRow)
        }

        addRow("Version", "Code Name")
        addRow("Android 9.0", "Pie")
        addRow("Android 8.0", "Oreo")

        addButton.setOnClickListener {
            addRow(editTextVersion.text.toString(), editTextName.text.toString())

            editTextName.text.clear()
            editTextVersion.text.clear()
        }
    }
}