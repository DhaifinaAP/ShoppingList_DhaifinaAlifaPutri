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
        lateinit var itemList: ArrayList<String>
        private lateinit var adapter: ArrayAdapter<String>

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                editTextItem = findViewById(R.id.editTextItem)
                buttonAdd = findViewById(R.id.buttonAdd)
                listViewItems = findViewById(R.id.listViewItems)

                itemList = ArrayList()
                adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList)
                listViewItems.adapter = adapter

                buttonAdd.setOnClickListener {
                        val newItem = editTextItem.text.toString()
                        if (newItem.isNotEmpty()) {
                                addItemToList(newItem)
                                editTextItem.text.clear()
                        }
                }

                listViewItems.setOnItemLongClickListener { _, _, position, _ ->
                        removeItemFromList(position)
                        true
                }
        }

        fun addItemToList(item: String) {
                itemList.add(item)
                adapter.notifyDataSetChanged()
        }

        fun removeItemFromList(position: Int) {
                itemList.removeAt(position)
                adapter.notifyDataSetChanged()
        }
}