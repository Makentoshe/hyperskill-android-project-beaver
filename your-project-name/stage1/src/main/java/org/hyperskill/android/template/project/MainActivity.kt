package org.hyperskill.android.template.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startButton)
        startButton.setOnClickListener {
            startGame()
        }

        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {
            //clickNext()
        }
    }

    private fun startGame() {
        val startButton = findViewById<Button>(R.id.startButton)
        startButton.visibility = View.INVISIBLE
        val nextButton = findViewById<Button>(R.id.nextButton)
        val inputText = findViewById<EditText>(R.id.inputText)
        val onScreenElements = arrayOf(nextButton, inputText)
        for (element in onScreenElements) {
            element.visibility = View.VISIBLE
        }
    }
}