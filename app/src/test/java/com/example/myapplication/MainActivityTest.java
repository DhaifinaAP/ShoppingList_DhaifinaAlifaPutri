package com.example.myapplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testAddition() {
        MainActivity mainActivity = activityRule.getActivity();
        assertEquals(4, mainActivity.addNumbers(2, 2));
    }

    /* Test case untuk memastikan activity berhasil diload */
    @Test
    public void testActivityLoad() {
        assertNotNull(activityRule.getActivity());
    }
}
