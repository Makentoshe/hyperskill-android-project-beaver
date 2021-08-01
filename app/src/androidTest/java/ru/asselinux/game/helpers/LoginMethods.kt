package ru.asselinux.game.helpers

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import ru.asselinux.game.R


fun performLogin(login: String = "login") {
    onView(withId(R.id.startButton)).perform(click())
    onView(withId(R.id.inputText)).perform(typeText(login))
    onView(withId(R.id.nextButton)).perform(click())
}

fun checkStayedOnLogin() {
    onView(withId(R.id.inputText)).check(matches(isDisplayed()))
}
