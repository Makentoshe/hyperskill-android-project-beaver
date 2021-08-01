package ru.asselinux.game

import android.widget.ImageButton
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers
import org.hamcrest.core.AllOf
import org.junit.Test
import ru.asselinux.game.helpers.checkStayedOnLogin
import ru.asselinux.game.helpers.findMoleImage
import ru.asselinux.game.helpers.performLogin
import ru.asselinux.game.matchers.isToast


class Stage3UnitTest : AppTest() {
    @Test
    fun stage3Test() {
        performLogin()

        onView(withId(R.id.scoreDisplay)).check(matches(isDisplayed()))

        onView(
            AllOf.allOf(
                withClassName(CoreMatchers.containsString(ImageButton::class.simpleName)),
                isDisplayed()
            )
        )

        findMoleImage().check(matches(isDisplayed()))
    }

    @Test
    fun emptyLoginTest() {
        performLogin("")
        checkStayedOnLogin()
    }

    @Test
    fun longLoginTest() {
        performLogin("1234567890QwErTyU")
        checkStayedOnLogin()
    }

    private fun isToastMessageDisplayed(text: String) {
        onView(withText(text)).inRoot(isToast()).check(matches(isDisplayed()))
    }
}