package org.hyperskill.android.template.project

import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import kotlin.math.roundToInt

@RunWith(RobolectricTestRunner::class)
class Stage5UnitTest {

    private val activityController = Robolectric.buildActivity(GameActivity::class.java)

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
    fun testShouldCheckScoreChangesTest() {
        val score: Int = (Math.random() * 9 + 1).roundToInt()
        for (i in 1..score) {
            punchMole()
        }
        getScore().check(ViewAssertions.matches(ViewMatchers.withText(score.toString())))
    }

    @Test
    fun testShouldCheckScoreNotChangesTest() {
        val score: Int = (Math.random() * 9 + 1).toInt()
        for (i in 1..score) {
            punchHole()
        }
        getScore().check(ViewAssertions.matches(ViewMatchers.withText("SCORE")))
    }
}