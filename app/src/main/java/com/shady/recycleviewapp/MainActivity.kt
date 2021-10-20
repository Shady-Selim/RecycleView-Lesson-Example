package com.shady.recycleviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.security.Principal
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var fillButton: Button
    private var data = mutableListOf<User>()
    private lateinit var appDB : AppDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvRecycleView)
        fillButton = findViewById(R.id.btnFill)

        val mainVM = ViewModelProvider(this).get(MainVM::class.java)

        mainVM.fillDB()

        fillButton.setOnClickListener(){
            mainVM.getAllUsers().observe(this, Observer {
                recyclerView.adapter = UserRecycleViewAdapter(it)
            })
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}