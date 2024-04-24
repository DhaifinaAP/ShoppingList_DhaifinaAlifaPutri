package com.example.myapplication

class ShoppingListManager {
    private val itemList: ArrayList<String> = ArrayList()

    fun addItem(item: String) {
        itemList.add(item)
    }

    fun removeItem(position: Int) {
        if (itemList.isNotEmpty() && position in 0 until itemList.size) {
            itemList.removeAt(position)
        } else {
            throw IndexOutOfBoundsException("Invalid position: $position")
        }
    }

    fun getItemList(): List<String> {
        return itemList.toList()
    }
}
