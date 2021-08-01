package ru.asselinux.game.helpers

import android.view.View
import androidx.test.espresso.Espresso
import org.hamcrest.Matcher

fun getView(matcher: Matcher<View>): View {
    var view: View? = null
    Espresso.onView(matcher).check { mView, _ ->
        view = mView
    }
    return view!!
}