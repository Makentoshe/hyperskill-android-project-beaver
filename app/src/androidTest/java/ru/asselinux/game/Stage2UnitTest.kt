package ru.asselinux.game

import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Test


class Stage2UnitTest : AppTest() {
    @Test
    fun stage2Test() {
        onView(withId(R.id.startButton))
            .check(matches(isDisplayed()))
            .check(matches(isClickable()))
            .perform(click())

        onView(withId(R.id.inputText))
            .check(matches(isDisplayed()))

        onView(withId(R.id.nextButton))
            .check(matches(isDisplayed()))
            .check(matches(isClickable()))
    }
}