package com.appfortraining.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.appfortraining.models.Day

@Dao
interface DayDao {

    @Query("SELECT*FROM days")
    fun getAllDays(): LiveData<List<Day>>

    @Insert
    suspend fun insertDay(day:Day)

    @Query("DELETE FROM days WHERE day_id=:id")
    suspend fun deleteDay(id:Int)
}