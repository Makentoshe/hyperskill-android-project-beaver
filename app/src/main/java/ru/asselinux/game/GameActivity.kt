package ru.asselinux.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class GameActivity : AppCompatActivity() {

    var score = 0
    var playerScore: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        playerScore = findViewById(R.id.scoreDisplay)
        playGame()
    }


    fun playGame() {
        if (score >= 10) {
            startActivity(Intent(this, WinActivity::class.java))
        } else {
            val image = pickImage()
            clickable(image).start()
        }
    }

    fun pickImage(): ImageButton {
        val images = findViewById<ConstraintLayout>(R.id.gameLayout).touchables
        images.shuffle()
        val randomImage = images[0] as ImageButton
        randomImage.setImageResource(R.drawable.mole)
        return randomImage
    }

    fun clickable(image: ImageButton): CountDownTimer {
        image.setOnClickListener {
            image.setImageResource(R.drawable.hit)
            score++
            playerScore?.text = score.toString()
        }

        return object : CountDownTimer(1000, 100) {

            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                image.setImageResource(R.drawable.hole)
                image.setOnClickListener(null)
                playGame()
            }

        }
    }
}

