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
        //val diceImage2: ImageView = findViewById(R.id.imageView)
        /* when(diceRoll)
         {
             1 -> diceImage.setImageResource(R.drawable.dice_1)
             2 -> diceImage.setImageResource(R.drawable.dice_2)
             3 -> diceImage.setImageResource(R.drawable.dice_3)
             4 -> diceImage.setImageResource(R.drawable.dice_4)
             5 -> diceImage.setImageResource(R.drawable.dice_5)
             else -> diceImage.setImageResource(R.drawable.dice_6)
         }*/
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //update the image with correct drawable resource id
        diceImage.setImageResource(drawableResource)
        //update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSlides: Int) {
    fun roll(): Int {
        return (1..numSlides).random()
    }
}