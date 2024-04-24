package com.example.myapplication

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MainActivityTest {

    private lateinit var mainActivity: MainActivity

    @Before
    fun setUp() {
        mainActivity = MainActivity()
        mainActivity.onCreate(null) // Simulate activity creation
    }

    @Test
    fun testAddItemToList() {
        // Initial empty list
        assertTrue(mainActivity.itemList.isEmpty())

        // Add an item
        mainActivity.addItemToList("Test Item")

        // Check if the item is added to the list
        assertEquals(1, mainActivity.itemList.size)
        assertEquals("Test Item", mainActivity.itemList[0])
    }

    @Test
    fun testRemoveItemFromList() {
        // Add some items to the list
        mainActivity.itemList.addAll(listOf("Item 1", "Item 2", "Item 3"))

        // Remove an item
        mainActivity.removeItemFromList(1)

        // Check if the item is removed and the list size is updated
        assertEquals(2, mainActivity.itemList.size)
        assertEquals("Item 1", mainActivity.itemList[0])
        assertEquals("Item 3", mainActivity.itemList[1])
    }
}
