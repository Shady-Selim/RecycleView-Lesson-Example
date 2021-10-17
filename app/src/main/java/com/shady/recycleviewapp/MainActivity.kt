package com.shady.recycleviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var data = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvRecycleView)
        for (i in 1..100){
            val user = User(
                "fName $i",
                "lName $i",
                i,
                i * 2
            )
            data += user
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UserRecycleViewAdapter(data)


    }
}