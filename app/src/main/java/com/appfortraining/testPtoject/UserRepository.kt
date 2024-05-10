package com.appfortraining.testPtoject

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserRepository(
    private val userDao: UserDao
) {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    val userList: LiveData<List<User>> = userDao.getUsers()

    fun addUser(user: User){
        coroutineScope.launch (Dispatchers.IO){
            userDao.addUser(user)

        }
    }

    fun deleteUser(id:Int){
        coroutineScope.launch(Dispatchers.IO) {
            userDao.deleteUser(id)
        }
    }

}