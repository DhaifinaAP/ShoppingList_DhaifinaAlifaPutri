package com.example.myapplication

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ShoppingListManagerUnitTest {

    private lateinit var shoppingListManager: ShoppingListManager

    @Before
    fun setup() {
        shoppingListManager = ShoppingListManager()
    }

    @Test
    fun testAddItem() {
        shoppingListManager.addItem("Item 1")
        assertEquals(1, shoppingListManager.getItemList().size)
        assertEquals("Item 1", shoppingListManager.getItemList()[0])
    }

    @Test
    fun testRemoveItem() {
        shoppingListManager.addItem("Item 1")
        shoppingListManager.addItem("Item 2")
        shoppingListManager.addItem("Item 3")

        shoppingListManager.removeItem(1)

        assertEquals(2, shoppingListManager.getItemList().size)
        assertEquals("Item 1", shoppingListManager.getItemList()[0])
        assertEquals("Item 3", shoppingListManager.getItemList()[1])
    }
}
