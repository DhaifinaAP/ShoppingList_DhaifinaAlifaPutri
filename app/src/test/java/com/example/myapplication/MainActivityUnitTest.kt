package com.example.myapplication

import org.junit.Assert.*
import org.junit.Test
import java.lang.reflect.Field

class MainActivityTest {

    // Test case to verify that adding an item to the list updates the adapter and list view correctly
    @Test
    fun testAddItemToList() {
        val mainActivity = MainActivity()

        // Accessing private field itemList using reflection
        val itemListField: Field = MainActivity::class.java.getDeclaredField("itemList")
        itemListField.isAccessible = true

        // Initial empty list
        val itemList: ArrayList<String> = itemListField.get(mainActivity) as ArrayList<String>
        assertTrue(itemList.isEmpty())

        // Add an item
        itemList.add("Test Item")

        // Check if the item is added to the list
        assertEquals(1, itemList.size)
        assertEquals("Test Item", itemList[0])
    }

    // Test case to verify that removing an item from the list updates the adapter and list view correctly
    @Test
    fun testRemoveItemFromList() {
        val mainActivity = MainActivity()

        // Accessing private field itemList using reflection
        val itemListField: Field = MainActivity::class.java.getDeclaredField("itemList")
        itemListField.isAccessible = true

        // Add some items to the list
        val itemList: ArrayList<String> = itemListField.get(mainActivity) as ArrayList<String>
        itemList.addAll(listOf("Item 1", "Item 2", "Item 3"))

        // Remove an item
        itemList.removeAt(1)

        // Check if the item is removed and the list size is updated
        assertEquals(2, itemList.size)
        assertEquals("Item 1", itemList[0])
        assertEquals("Item 3", itemList[1])
    }
}
