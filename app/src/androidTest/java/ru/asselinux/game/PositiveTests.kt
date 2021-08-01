package ru.asselinux.game

import android.view.View
import android.widget.ImageButton
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.core.AllOf.allOf
import org.junit.Before
import org.junit.Test
import ru.asselinux.game.helpers.*
import java.lang.Math.random
import kotlin.math.roundToInt


class PositiveTests : AppTest() {
    @Before
    fun login() {
        performLogin()
    }


    @Test
    fun smokeTest() {
        onView(withId(R.id.scoreDisplay)).check(matches(isDisplayed()))

        onView(
            allOf(
                withClassName(containsString(ImageButton::class.simpleName)),
                isDisplayed()
            )
        )

        findMoleImage().check(matches(isDisplayed()))
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
        val score: Int = (random() * 9 + 1).roundToInt()
        for (i in 1..score) {
            punchMole()
        }
        getScore().check(matches(withText(score.toString())))
    }

    @Test
    fun scoreNotChangesTest() {
        val score: Int = (random() * 9 + 1).toInt()
        for (i in 1..score) {
            punchHole()
        }
        getScore().check(matches(withText("SCORE")))
    }

    @Test
    fun moleChanges() {
        val view: View = getView(withDrawable(R.drawable.mole))
        punchMole()

        onView(withId(view.id)).check(matches(withDrawable(R.drawable.molep)))
    }

    @Test
    fun moleMoves() {
        val view: View = getView(withDrawable(R.drawable.mole))

        assert(
            waitForMole(view.id) != null
        ) { "The mole was not moving from element wth id ${view.id}" }
    }


}