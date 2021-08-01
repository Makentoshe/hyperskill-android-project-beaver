package ru.asselinux.game.helpers

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import ru.asselinux.game.R
import ru.asselinux.game.WinActivity
import ru.asselinux.game.withDrawable
import ru.asselinux.game.withIndex

fun winActivityDisplayed() = runBlocking {
    repeat(5) {
        try {
            onView(withDrawable(R.drawable.congrats))
                .check(matches(isDisplayed()))
            Intents.intended(IntentMatchers.hasComponent(WinActivity::class.java.name))
            return@runBlocking
        } catch (e: Exception) {
            delay(500)
            // did not load, ignore
        }
    }
    assert(false) { "Was unable to find \"Congratulations\" activity" }
}

fun waitForMole(holeId: Int) = runBlocking {
    repeat(50) { i ->
        if (getView(withDrawable(R.drawable.mole)).id != holeId) {
            return@runBlocking i
        } else {
            delay(100)
        }
    }
    return@runBlocking null
}

fun findMoleImage(): ViewInteraction = runBlocking<ViewInteraction> {
    var result: ViewInteraction? = null
    repeat(5) {
        try {
            result = onView(
                withDrawable(R.drawable.mole),
            )
        } catch (e: Exception) {
            // could not find, ignore
        }
    }
    return@runBlocking result!!
}

fun findHoleImage(): ViewInteraction = runBlocking<ViewInteraction> {
    var result: ViewInteraction? = null
    repeat(5) {
        try {
            result = onView(withIndex(withDrawable(R.drawable.hole), 0))
        } catch (e: Exception) {
            print(e)
        }
    }
    return@runBlocking result!!
}

fun getScore(): ViewInteraction {
    return onView(withId(R.id.scoreDisplay))
}

fun punchMole(): ViewInteraction {
    var success: ViewInteraction? = null
    while (success == null) {
        try {
            success = findMoleImage().perform(ViewActions.click())
        } catch (e: Exception) {
            // could not punch, ignore
        }
    }
    return success
}

fun punchHole() {
    var success = false
    while (!success) {
        try {
            findHoleImage().perform(ViewActions.click())
            success = true
        } catch (e: Exception) {
            // could not punch, ignore
        }
    }
}
