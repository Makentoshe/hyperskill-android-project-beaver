package org.hyperskill.android.template.project

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class Stage4UnitTest {

    private val activityController = Robolectric.buildActivity(GameActivity::class.java)

    @Test
    fun testShouldCheckIfMoleMoves() {
        performLogin()
        val view: View = getView(withDrawable(R.drawable.mole))

        assert(
            waitForMole(view.id) != null
        ) { "The mole was not moving from element wth id ${view.id}" }
    }

    @Test
    fun testShouldCheckIfHasTouchables() {
        performLogin()
        val view: View = getView(ViewMatchers.withId(R.id.gameLayout))

        assert(
            view.touchables != null && view.touchables.size > 1
        ) { "Could not find any touchables" }
    }
}