package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {

        private lateinit var editTextItem: EditText
        private lateinit var buttonAdd: Button
        private lateinit var listViewItems: ListView
        private lateinit var itemList: MutableList<String>
        private lateinit var adapter: ArrayAdapter<String>

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                // Inisialisasi tampilan dan adapter
                editTextItem = findViewById(R.id.editTextItem)
                buttonAdd = findViewById(R.id.buttonAdd)
                listViewItems = findViewById(R.id.listViewItems)

                itemList = ArrayList()
                adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList)
                listViewItems.adapter = adapter

                // Set listener untuk buttonAdd
                buttonAdd.setOnClickListener {
                        val newItem = editTextItem.text.toString()
                        if (newItem.isNotEmpty()) {
                                addItemToList(newItem)
                                editTextItem.text.clear()
                        }
                }

                // Set listener untuk item yang diklik dalam listViewItems
                listViewItems.setOnItemLongClickListener { _, _, position, _ ->
                        removeItemFromList(position)
                        true
                }
        }

        // Metode publik untuk menambahkan item ke daftar
        private fun addItemToList(item: String) {
                itemList.add(item)
                adapter.notifyDataSetChanged()
        }

        // Metode publik untuk menghapus item dari daftar
        private fun removeItemFromList(position: Int) {
                if (itemList.isNotEmpty() && position in 0 until itemList.size) {
                        itemList.removeAt(position)
                        adapter.notifyDataSetChanged()
                }
        }
}
