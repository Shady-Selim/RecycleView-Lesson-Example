package com.shady.recycleviewapp

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppRepo(context: Context) {
    private val appDB = AppDataBase.getAppDataBase(context)!!

    suspend fun getAllUsers(): List<User> = withContext(Dispatchers.IO) {
        appDB.userDao.getAllUsers()
    }

    suspend fun fillDB() = withContext(Dispatchers.IO) {
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
}