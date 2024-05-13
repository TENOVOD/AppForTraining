package com.appfortraining.vm

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.appfortraining.TrainingRoomDatabase
import com.appfortraining.models.Exercise
import com.appfortraining.repositories.ExerciseRepository

class ExerciseViewModel(application: Application) : ViewModel(){

    val exerciseList: LiveData<List<Exercise>>
    private val repository: ExerciseRepository
    var exerciseName by mutableStateOf("")
    var exerciseRepetitions by mutableStateOf(0)

    init{
        val exerciseDb = TrainingRoomDatabase.getInstance(application)
        val exerciseDao = exerciseDb.exerciseDao()
        repository = ExerciseRepository(exerciseDao)
        exerciseList=repository.exerciseList
    }

    fun changeName(value: String){
        exerciseName=value
    }

    fun changeRepetition(value:String){
        exerciseRepetitions=value.toIntOrNull()?:exerciseRepetitions
    }

    fun addExercise(){
        val unixTimeSeconds = System.currentTimeMillis()/1000
        repository.addExercise(Exercise(exerciseName,exerciseRepetitions,unixTimeSeconds))
    }

    fun deleteExercise(id: Int){
        repository.deleteExercise(id)
    }
}