package com.example.myapplication

class ShoppingListManager {
    // Properti privat untuk menyimpan daftar barang
    private val itemList: ArrayList<String> = ArrayList()

    // Metode untuk menambahkan barang ke dalam daftar
    fun addItem(item: String) {
        itemList.add(item)
    }

    // Metode untuk menghapus barang dari daftar pada posisi yang ditentukan
    fun removeItem(position: Int) {
        // Memeriksa apakah daftar tidak kosong dan apakah posisi valid
        if (itemList.isNotEmpty() && position in 0 until itemList.size) {
            itemList.removeAt(position)
        } else {
            // Melemparkan pengecualian jika posisi tidak valid
            throw IndexOutOfBoundsException("Posisi tidak valid: $position")
        }
    }

    // Metode untuk mendapatkan daftar barang
    fun getItemList(): List<String> {
        // Mengembalikan salinan daftar yang hanya dapat dibaca untuk mencegah modifikasi eksternal
        return itemList.toList()
    }
}
