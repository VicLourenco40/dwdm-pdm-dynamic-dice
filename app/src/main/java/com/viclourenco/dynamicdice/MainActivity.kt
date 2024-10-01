package com.viclourenco.dynamicdice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val legend: TextView = findViewById(R.id.diceText)
        val image: ImageView = findViewById(R.id.diceImage)
        val button: Button = findViewById(R.id.diceButton)

        button.setOnClickListener {
            val randomInt = (1 .. 6).random()

            legend.text = randomInt.toString()

            val resId = resources.getIdentifier("dice_" + randomInt, "drawable", packageName)

            image.setImageResource(resId);
        }
    }
}