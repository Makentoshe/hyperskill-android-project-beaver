package ru.asselinux.game

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import org.junit.Test
import ru.asselinux.game.helpers.getView
import ru.asselinux.game.helpers.performLogin
import ru.asselinux.game.helpers.waitForMole

class Stage5UnitTest : AppTest() {

    @Test
    fun moleMoves() {
        performLogin()
        val view: View = getView(withDrawable(R.drawable.mole))

        assert(
            waitForMole(view.id) != null
        ) { "The mole was not moving from element wth id ${view.id}" }
    }

    @Test
    fun hasTouchables()
    {
        performLogin()
        val view: View = getView(ViewMatchers.withId(R.id.gameLayout))

        assert(
            view.touchables != null && view.touchables.size > 1
        ) {"Could not find any touchables"}
    }
}