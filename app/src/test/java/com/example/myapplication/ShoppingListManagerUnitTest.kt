package com.example.myapplication

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ShoppingListManagerUnitTest {

    private lateinit var shoppingListManager: ShoppingListManager

    // Metode setup untuk menginisialisasi ShoppingListManager sebelum setiap pengujian
    @Before
    fun setup() {
        shoppingListManager = ShoppingListManager()
    }

    /**
     * Test Case untuk menambahkan item ke dalam daftar belanja.
     * Ini menambahkan sebuah item dan memeriksa apakah item tersebut ditambahkan dengan benar ke dalam daftar.
     */
    @Test
    fun testAddItem() {
        // Menambahkan sebuah item ke dalam daftar belanja
        shoppingListManager.addItem("Item 1")

        // Memeriksa apakah ukuran dari daftar adalah 1 dan item yang ditambahkan adalah "Item 1"
        assertEquals(1, shoppingListManager.getItemList().size)
        assertEquals("Item 1", shoppingListManager.getItemList()[0])
    }

    /**
     * Test Case untuk menghapus item dari daftar belanja.
     * Ini menambahkan beberapa item, menghapus salah satunya, dan memeriksa apakah item tersebut dihapus dengan benar dari daftar.
     */
    @Test
    fun testRemoveItem() {
        // Menambahkan beberapa item ke dalam daftar belanja
        shoppingListManager.addItem("Item 1")
        shoppingListManager.addItem("Item 2")
        shoppingListManager.addItem("Item 3")

        // Menghapus item pada indeks 1 (item kedua)
        shoppingListManager.removeItem(1)

        // Memeriksa apakah ukuran dari daftar adalah 2 dan itemnya adalah "Item 1" dan "Item 3"
        assertEquals(2, shoppingListManager.getItemList().size)
        assertEquals("Item 1", shoppingListManager.getItemList()[0])
        assertEquals("Item 3", shoppingListManager.getItemList()[1])
    }
}
