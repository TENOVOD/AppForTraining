package com.appfortraining.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import com.appfortraining.DAO.DayDao
import com.appfortraining.models.Day
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DayRepository(
    private val dayDao: DayDao
) {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    val dayList: LiveData<List<Day>> = dayDao.getAllDays()

    //add day after checking for the similar record
    fun addDay() {
        val currentTimeInMilliseconds = System.currentTimeMillis() / 1000
        val dayName = convertUnixTimestampToDayOfWeek(currentTimeInMilliseconds)
        val dayDate = convertUnixTimestampToDate(currentTimeInMilliseconds)

        coroutineScope.launch(Dispatchers.IO) {

            val existDay = dayDao.getDayByDate(dayDate)
            if (existDay == null) {
                val day = Day(
                    dayDate = dayDate,
                    dayName = dayName
                )
                dayDao.insertDay(day)
                Log.d("GG", "Im work")
            }

        }

    }

    private fun convertUnixTimestampToDayOfWeek(timestamp: Long): String {
        val date = Date(timestamp * 1000)
        val dayFormat = SimpleDateFormat("EEEE", Locale.ENGLISH)
        return dayFormat.format(date)
    }
    private fun convertUnixTimestampToDate(timestamp: Long): String {
        val date = Date(timestamp * 1000)
        val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
        return dateFormat.format(date)
    }

}