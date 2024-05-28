package com.appfortraining.vm

import android.app.Application
import android.util.Log
import androidx.compose.runtime.currentComposer
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appfortraining.TrainingRoomDatabase
import com.appfortraining.models.Day
import com.appfortraining.repositories.DayRepository
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DayViewModel (application: Application):ViewModel(){

    val dayList:LiveData<List<Day>>
    private val repository:DayRepository


    init{
        val dayDb=TrainingRoomDatabase.getInstance(application)
        val dayDao=dayDb.dayDao()
        repository = DayRepository(dayDao)
        dayList=repository.dayList
        viewModelScope.launch {
            repository.addDay()
        }
    }


}