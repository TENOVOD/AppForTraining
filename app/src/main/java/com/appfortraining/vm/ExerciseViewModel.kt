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
    var isWeightEnable by mutableStateOf(false)
    var exerciseWeight by mutableStateOf("")

    init{
        val exerciseDb = TrainingRoomDatabase.getInstance(application)
        val exerciseDao = exerciseDb.exerciseDao()
        repository = ExerciseRepository(exerciseDao)
        exerciseList=repository.exerciseList
    }

    fun changeName(value: String){
        exerciseName=value
    }

    fun onWeightOptionChanged(enable: Boolean){
        isWeightEnable=enable
    }

    fun changeWeight(weight:String){
        exerciseWeight=weight
    }

    fun changeRepetition(value:String){
        exerciseRepetitions=value.toIntOrNull()?:exerciseRepetitions
    }

    fun addExercise(){
        val res = if (exerciseWeight.isEmpty()) 0f else exerciseWeight.toFloat()
        repository.addExercise(Exercise(exerciseName,exerciseRepetitions,res,0))
    }

    fun deleteExercise(id: Long){
        repository.deleteExercise(id)
    }
}