package com.appfortraining.repositories

import com.appfortraining.DAO.DayDao
import com.appfortraining.models.Day
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DayRepository(
    private val dayDao:DayDao
) {
    private val coroutineScope= CoroutineScope(Dispatchers.Main)

    fun addDay(day: Day){
        coroutineScope.launch(Dispatchers.IO) {
            dayDao.insertDay(day)
        }
    }
}