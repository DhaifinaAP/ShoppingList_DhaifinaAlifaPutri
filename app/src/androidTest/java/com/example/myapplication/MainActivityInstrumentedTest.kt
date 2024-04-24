package com.example.myapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @Test
    fun addItemToList() {
        // Launch the activity
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Enter text into the EditText and click the add button
        onView(withId(R.id.editTextItem)).perform(typeText("Test Item"), closeSoftKeyboard())
        onView(withId(R.id.buttonAdd)).perform(click())

        // Check if the item is added to the list
        onView(withText("Test Item")).check(matches(isDisplayed()))

        // Close the activity
        scenario.close()
    }

    @Test
    fun removeItemFromList() {
        // Launch the activity
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Add an item to the list
        onView(withId(R.id.editTextItem)).perform(typeText("Test Item"), closeSoftKeyboard())
        onView(withId(R.id.buttonAdd)).perform(click())

        // Long press to remove the item
        onView(withText("Test Item")).perform(longClick())

        // Check if the item is removed from the list
        onView(withText("Test Item")).check(doesNotExist())

        // Close the activity
        scenario.close()
    }
}
