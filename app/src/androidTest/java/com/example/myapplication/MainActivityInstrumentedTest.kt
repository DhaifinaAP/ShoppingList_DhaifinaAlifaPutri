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

    /**
     * Test Case untuk menambahkan item ke dalam daftar.
     * Ini menjalankan aktivitas, memasukkan teks ke dalam EditText, mengklik tombol tambah,
     * dan memeriksa apakah item ditampilkan dalam daftar.
     */
    @Test
    fun addItemToList() {
        // Menjalankan aktivitas
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Memasukkan teks ke dalam EditText dan mengklik tombol tambah
        onView(withId(R.id.editTextItem)).perform(typeText("Test Item"), closeSoftKeyboard())
        onView(withId(R.id.buttonAdd)).perform(click())

        // Memeriksa apakah item ditambahkan ke dalam daftar
        onView(withText("Test Item")).check(matches(isDisplayed()))

        // Menutup aktivitas
        scenario.close()
    }

    /**
     * Test Case untuk menghapus item dari daftar.
     * Ini menjalankan aktivitas, menambahkan item, melakukan long press untuk menghapusnya,
     * dan memeriksa apakah item tersebut benar-benar dihapus dari daftar.
     */
    @Test
    fun removeItemFromList() {
        // Menjalankan aktivitas
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Menambahkan item ke dalam daftar
        onView(withId(R.id.editTextItem)).perform(typeText("Test Item"), closeSoftKeyboard())
        onView(withId(R.id.buttonAdd)).perform(click())

        // Long press untuk menghapus item
        onView(withText("Test Item")).perform(longClick())

        // Memeriksa apakah item telah dihapus dari daftar
        onView(withText("Test Item")).check(doesNotExist())

        // Menutup aktivitas
        scenario.close()
    }
}
