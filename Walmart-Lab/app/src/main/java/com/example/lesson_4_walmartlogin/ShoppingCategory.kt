package com.example.lesson_4_walmartlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shopping_category.*

class ShoppingCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        user_id.text = intent.getStringExtra("email")
    }

    fun onClick(v: View?) {
        val map = mapOf(
            R.id.electronic to getString(R.string.shopping_cart_electronics),
            R.id.clothing to getString(R.string.shopping_cart_clothing),
            R.id.beauty to getString(R.string.shopping_cart_beauty),
            R.id.food to getString(R.string.shopping_cart_food)
        )

        Toast.makeText(applicationContext, "You have chosen the ${map.get(v?.id)} category of shopping", Toast.LENGTH_SHORT).show()
    }
}