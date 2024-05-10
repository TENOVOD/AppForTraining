package com.appfortraining.testPtoject

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class UserViewModel (application:Application): ViewModel() {

    val userList: LiveData<List<User>>
    private val repository: UserRepository
    var userName by mutableStateOf("")
    var userAge by mutableStateOf(0)


    init{
        val userDb = UserRoomDatabase.getInstance(application)
        val userDao = userDb.userDao()
        repository = UserRepository(userDao)
        userList = repository.userList
    }

    fun changeName(value: String){
        userName = value
    }

    fun changeAge(value: String){
        userAge = value.toIntOrNull()?:userAge
    }

    fun addUser(){
        repository.addUser(User(userName, userAge))
    }

    fun deleteUser(id: Int){
        repository.deleteUser(id)
    }



}