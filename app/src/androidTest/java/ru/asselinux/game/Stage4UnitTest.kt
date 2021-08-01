package ru.asselinux.game

import android.widget.ImageButton
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers
import org.hamcrest.core.AllOf
import org.junit.Test
import ru.asselinux.game.helpers.findHoleImage
import ru.asselinux.game.helpers.findMoleImage


class Stage4UnitTest : AppTest() {
    @Test
    fun stage4Test() {
        activityRule.activity.beginGame("some_login")
        intended(hasComponent(GameActivity::class.java.name))

        onView(withId(R.id.scoreDisplay)).check(matches(isDisplayed()))

        onView(
            AllOf.allOf(
                withClassName(CoreMatchers.containsString(ImageButton::class.simpleName)),
                isDisplayed()
            )
        )
        val imageButtons = arrayListOf<ViewInteraction>()
        for (i in 0..4) {
            imageButtons.add(onView(withIndex(withClassName(CoreMatchers.containsString(ImageButton::class.simpleName)), i)))
        }
        for (i in 0..4) {
            imageButtons[i].check(matches(isDisplayed()))
        }
    }
}