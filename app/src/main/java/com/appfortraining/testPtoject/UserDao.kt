package com.appfortraining.testPtoject

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface UserDao {

    @Query("SELECT*FROM users")
    fun getUsers():LiveData<List<User>>

    @Insert
    fun addUser(user:User)

    @Query("DELETE FROM users WHERE userId=:id")
    fun deleteUser(id:Int)

}