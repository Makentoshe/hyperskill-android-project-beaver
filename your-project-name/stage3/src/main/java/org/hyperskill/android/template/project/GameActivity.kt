package org.hyperskill.android.template.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }
}