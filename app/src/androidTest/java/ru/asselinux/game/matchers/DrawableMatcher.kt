package ru.asselinux.game

import android.graphics.PorterDuff
import android.view.View
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.graphics.drawable.toBitmap
import androidx.core.graphics.toColor
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

fun withDrawable(
    @DrawableRes id: Int,
    @ColorRes tint: Int? = null,
    tintMode: PorterDuff.Mode = PorterDuff.Mode.SRC_IN
) = object : TypeSafeMatcher<View>() {

    override fun describeTo(description: Description) {
        description.appendText("ImageView with drawable same as drawable with id $id")
        tint?.let { description.appendText(", tint color id: $tint, mode: $tintMode") }
    }

    override fun matchesSafely(view: View): Boolean {
        view.resources
        val context = view.context
        val tintColor = tint?.toColor()
        val drawable = context.getDrawable(id)
        tint?.let {
            drawable?.setTint(it)
            drawable?.setTintMode(tintMode)
        }

        val expectedBitmap = drawable?.toBitmap()
        return view is ImageView && view.drawable.toBitmap().sameAs(expectedBitmap)
    }
}