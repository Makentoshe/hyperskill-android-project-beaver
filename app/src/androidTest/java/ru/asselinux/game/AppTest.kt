package ru.asselinux.game

import androidx.test.espresso.Espresso
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.After
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
open class AppTest {
    @get:Rule
    val activityRule = IntentsTestRule(MainActivity::class.java)

    @After
    fun close() {
        Espresso.pressBackUnconditionally()
    }
}