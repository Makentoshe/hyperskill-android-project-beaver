package org.hyperskill.android.template.project

import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.slider.Slider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class Stage1UnitTest {

    private val activityController = Robolectric.buildActivity(MainActivity::class.java)

    @Test
    fun testShouldCheckEditTextExist() {
        val activity = activityController.setup().get()
        val editText = activity.findViewById<EditText>(R.id.inputText)

        val message = "does view with id \"inputText\" placed in activity?"
        assertNotNull(message, editText)

        val message2 = "inputText should have proper inputType attribute"
        assertEquals(message2, editText.inputType, EditorInfo.TYPE_CLASS_NUMBER)
    }

//    @Test
//    fun testShouldCheckSliderExist() {
//        val activity = activityController.setup().get()
//        val slider = activity.findViewById<Slider>(R.id.slider)
//
//        val message = "does view with id \"slider\" placed in activity?"
//        assertNotNull(message, slider)
//
//        val message2 = "\"slider\" should have proper stepSize attribute"
//        assertEquals(message2, slider.stepSize, 1.0f)
//
//        val message3 = "\"slider\" should have proper valueFrom attribute"
//        assertEquals(message3, slider.valueFrom, 0.0f)
//
//        val message4 = "\"slider\" should have proper valueTo attribute"
//        assertEquals(message4, slider.valueTo, 100.0f)
//
//        val message5 = "\"slider\" should have proper initial value"
//        assertEquals(message5, 0f, slider.value)
//    }

    @Test
    fun testShouldCheckButtonStartExist() {
        val activity = activityController.setup().get()

        val message = "does view with id \"startButton\" placed in activity?"
        assertNotNull(message, activity.findViewById<Button>(R.id.startButton))
    }

    @Test
    fun testShouldCheckButtonNextExist() {
        val activity = activityController.setup().get()

        val message = "does view with id \"nextButton\" placed in activity?"
        assertNotNull(message, activity.findViewById<Button>(R.id.nextButton))
    }
}