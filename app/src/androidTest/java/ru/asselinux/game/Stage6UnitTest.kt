package ru.asselinux.game

import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import org.junit.Before
import org.junit.Test
import ru.asselinux.game.helpers.*
import kotlin.math.roundToInt

class Stage6UnitTest : AppTest() {

    @Before
    fun login() {
        performLogin()
    }

    @Test
    fun fullGameTest() {
        for (i in 1..10) {
            punchMole()
        }
        winActivityDisplayed()
    }

    @Test
    fun scoreChangesTest() {
        val score: Int = (Math.random() * 9 + 1).roundToInt()
        for (i in 1..score) {
            punchMole()
        }
        getScore().check(ViewAssertions.matches(ViewMatchers.withText(score.toString())))
    }

    @Test
    fun scoreNotChangesTest() {
        val score: Int = (Math.random() * 9 + 1).toInt()
        for (i in 1..score) {
            punchHole()
        }
        getScore().check(ViewAssertions.matches(ViewMatchers.withText("SCORE")))
    }
}