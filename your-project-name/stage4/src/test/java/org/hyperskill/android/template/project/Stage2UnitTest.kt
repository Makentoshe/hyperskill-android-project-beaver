package org.hyperskill.android.template.project

import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.google.android.material.slider.Slider
import org.hamcrest.core.AllOf
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class Stage2UnitTest {

    private val activityController = Robolectric.buildActivity(MainActivity::class.java)

    @Test
    fun stage3Test() {
        performLogin()

        Espresso.onView(withId(R.id.scoreDisplay))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(
            AllOf.allOf(
                withClassName(CoreMatchers.containsString(ImageButton::class.simpleName)),
                isDisplayed()
            )
        )

        findMoleImage().check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
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
        Espresso.onView(ViewMatchers.withText(text))
            .inRoot(isToast()).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}