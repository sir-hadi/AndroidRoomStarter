package com.example.android.androidroomstarter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.androidroomstarter.entities.Task
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import java.util.ArrayList
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var num = 1
    lateinit var items : ArrayList<ItemDataHolder>
    lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = TodoDatabase.getInstance(this).todoDao()
        num = dao.getLastId()
        dao.insertTask(Task(num,"Something ${num}",false))



        items = ArrayList()
        val taskList = dao.getAll()
        taskList.forEach {
            items.add(ItemDataHolder(R.drawable.ic_launcher_background,
                    "Something ${it.id}",
                    false
                )
            )
        }

        adapter = TodoAdapter(items)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)

        add.setOnClickListener {
            lifecycleScope.launch {
                ++num
                dao.insertTask(Task(num,"Something ${num}",false))
                val newItem = ItemDataHolder(
                        R.drawable.ic_launcher_background,
                        "Something ${num}",
                        false
                )
                items.add(0,newItem)
                adapter.notifyItemInserted(0)
                recycler_view.smoothScrollToPosition(0);

            }
        }
    }

}