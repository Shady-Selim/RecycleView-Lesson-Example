package com.shady.recycleviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

        appDB = AppDataBase.getAppDataBase(this)!!


        thread {
            val dataDB = appDB.userDao.getAllUsers()
            if (dataDB.isEmpty()) {
                for (i in 1..100) {
                    val user = User(
                        fName = "fName $i",
                        lName = "lName $i",
                        id = i,
                        score = i * 2
                    )
                    appDB.userDao.insert(user)
                }
            }
        }

        fillButton.setOnClickListener(){
                //data += user
            thread {
                val rvAdaptorData = appDB.userDao.getAllUsers()
                runOnUiThread {
                    recyclerView.adapter = UserRecycleViewAdapter(rvAdaptorData)
                }
            }
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}