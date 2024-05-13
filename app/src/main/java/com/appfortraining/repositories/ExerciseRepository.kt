package com.appfortraining.repositories

import androidx.lifecycle.LiveData
import com.appfortraining.DAO.ExerciseDao
import com.appfortraining.models.Exercise
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class ExerciseRepository (
    private val exerciseDao:ExerciseDao
){
    private val coroutineScope=CoroutineScope(Dispatchers.Main)

    val exerciseList: LiveData<List<Exercise>> = exerciseDao.getAllExercises()

    fun addExercise(exercise: Exercise){
        coroutineScope.launch(Dispatchers.IO){
            exerciseDao.addExercise(exercise)
        }
    }

    fun deleteExercise(id:Int){
        coroutineScope.launch(Dispatchers.IO){
            exerciseDao.deleteExercise(id)
        }
    }
 }