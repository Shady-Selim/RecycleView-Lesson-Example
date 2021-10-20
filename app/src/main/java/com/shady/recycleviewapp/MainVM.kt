package com.shady.recycleviewapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainVM(context: Application) : AndroidViewModel(context){
    private val repo = AppRepo(context)

    fun getAllUsers(): MutableLiveData<List<User>> {
        val users = MutableLiveData<List<User>>()
        viewModelScope.launch {
            users.postValue(repo.getAllUsers())
        }
        return users
    }

    fun fillDB()  = viewModelScope.launch {
        repo.fillDB()
    }

}