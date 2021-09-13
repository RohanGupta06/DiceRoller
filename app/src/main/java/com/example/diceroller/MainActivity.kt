package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        // Create new dice object with 6 slides and Roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Update the screen with the text of diceRoll
        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.setImageResource(R.drawable.dice_2)
    }
}

class Dice(private val numSlides: Int) {
    fun roll(): Int {
        return (1..numSlides).random()
    }
}