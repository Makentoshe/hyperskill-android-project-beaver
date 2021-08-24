package org.hyperskill.android.template.project

import android.widget.ImageButton
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.CoreMatchers
import org.hamcrest.core.AllOf
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class Stage3UnitTest {

    @Test
    fun stage4Test() {
        activityRule.activity.beginGame("some_login")
        intended(hasComponent(GameActivity::class.java.name))

        Espresso.onView(withId(R.id.scoreDisplay))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(
            AllOf.allOf(
                withClassName(CoreMatchers.containsString(ImageButton::class.simpleName)),
                isDisplayed()
            )
        )
        val imageButtons = arrayListOf<ViewInteraction>()
        for (i in 0..4) {
            imageButtons.add(
                Espresso.onView(
                    withIndex(
                        ViewMatchers.withClassName(
                            CoreMatchers.containsString(
                                ImageButton::class.simpleName
                            )
                        ), i
                    )
                )
            )
        }
        for (i in 0..4) {
            imageButtons[i].check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        }
    }
}