package ru.asselinux.game

import androidx.test.espresso.Espresso
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
open class GameTest {
    @get:Rule
    val activityRule = ActivityTestRule(GameActivity::class.java, true, false)

    @After
    fun close() {
        Espresso.pressBackUnconditionally()
    }
}