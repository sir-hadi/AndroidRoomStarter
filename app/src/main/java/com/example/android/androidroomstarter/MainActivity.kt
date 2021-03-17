package com.example.android.androidroomstarter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.androidroomstarter.entities.ItemDataHolder
import com.example.android.androidroomstarter.entities.Task
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    var num = 1
    lateinit var adapter: TodoAdapter

    var predefineData = arrayListOf(
        ItemDataHolder(R.drawable.ic_launcher_background,"Sepatu Hiking",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Gaiter",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Sleeping Bag",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Jaket",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Jas Hujan",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Tenda",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Kompor Kecil",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Gas Kaleng",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Pisau Masak",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Gunting",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Sendok",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Garpu",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Pakaian Ganti Kering 1",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Pakaian Ganti Kering 2",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Pakaian Ganti Kering 3",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Pakaian Ganti Kering 4",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Peralatan Medis",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Kaos Kaki",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Matras",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Senter",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Kompas",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Trash bag",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Sandal Jepit",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Celana Panjang 1",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Celana Panjang 2",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Topi",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Tali",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Powerbank",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Pisau Lipat",false),
        ItemDataHolder(R.drawable.ic_launcher_background,"Peta Jalur",false)
    )

    lateinit var dao : TodoDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dao = TodoDatabase.getInstance(this).todoDao()

        predefineData.forEach { dao.insertTask(it) }
        predefineData = dao.getAll() as ArrayList<ItemDataHolder>


        adapter = TodoAdapter(predefineData)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)

        add.setOnClickListener {
            lifecycleScope.launch {
                ++num
                dao.insertTask(ItemDataHolder(R.drawable.ic_launcher_background,"Peta ${num}",false))
                val newItem = ItemDataHolder(
                        R.drawable.ic_launcher_background,
                        "Something ${num}",
                        false
                )
                predefineData.add(0,newItem)
                adapter.notifyItemInserted(0)
                adapter.notifyDataSetChanged()
                recycler_view.smoothScrollToPosition(0);

            }
        }
    }



}