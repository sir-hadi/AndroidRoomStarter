package com.example.android.androidroomstarter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import com.example.android.androidroomstarter.entities.Task
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import java.util.ArrayList
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var num = 0
    lateinit var items : ArrayList<String>
    lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = TodoDatabase.getInstance(this).todoDao()
        dao.insertTask(Task(++num,"Something ${num}",false))

        items = ArrayList()
        val taskList = dao.getAll()
        taskList.forEach { items.add(it.taskName) }
        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            items
        )
        list_view.adapter = adapter

        add.setOnClickListener {
            lifecycleScope.launch {
                dao.insertTask(Task(++num,"Something ${num}",false))
                items.add("Something ${num}")
                adapter.notifyDataSetChanged()

            }
        }


    }
}