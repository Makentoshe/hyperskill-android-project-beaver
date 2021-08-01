package ru.asselinux.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class WinActivity : AppCompatActivity() {
//    var winner: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win)
//        winner = findViewById(R.id.winText)
//        winner?.text = "Congratulations"
    }
}