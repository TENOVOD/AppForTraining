package com.appfortraining.vm

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.appfortraining.TrainingRoomDatabase
import com.appfortraining.models.Day
import com.appfortraining.repositories.DayRepository

class DayViewModel (application: Application):ViewModel(){

    val dayList:LiveData<List<Day>>
    private val repository:DayRepository


    init{
        val dayDb=TrainingRoomDatabase.getInstance(application)
        val dayDao=dayDb.dayDao()
        repository = DayRepository(dayDao)
        dayList=repository.dayList
    }

}