package com.appfortraining.repositories

import androidx.lifecycle.LiveData
import com.appfortraining.DAO.DayDao
import com.appfortraining.models.Day
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DayRepository(
    private val dayDao:DayDao
) {
    private val coroutineScope= CoroutineScope(Dispatchers.Main)

    val dayList:LiveData<List<Day>> =dayDao.getAllDays()

    fun addDay(day: Day){
        coroutineScope.launch(Dispatchers.IO) {
            dayDao.insertDay(day)
        }
    }
}