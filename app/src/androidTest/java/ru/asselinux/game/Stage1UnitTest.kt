package ru.asselinux.game

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Test


class Stage1UnitTest : AppTest() {
    @Test
    fun stage1Test() {
        onView(withId(R.id.startButton))
            .check(matches(isDescendantOfA(withId(R.id.mainLayout))))
            .check(matches(withText("START")))

        onView(withId(R.id.inputText))
            .check(matches(isDescendantOfA(withId(R.id.mainLayout))))

        onView(withId(R.id.nextButton))
            .check(matches(isDescendantOfA(withId(R.id.mainLayout))))
            .check(matches(withText("NEXT")))
    }
}