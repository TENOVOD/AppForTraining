package com.appfortraining.repositories

import androidx.lifecycle.LiveData
import com.appfortraining.DAO.DayExercisesDao
import com.appfortraining.models.Exercise
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class ExerciseRepository (
    private val dayExerciseDao: DayExercisesDao
){
    private val coroutineScope=CoroutineScope(Dispatchers.Main)

    val exerciseList: LiveData<List<Exercise>> = dayExerciseDao.getAllExercises()

    fun addExercise(exercise: Exercise){
        coroutineScope.launch(Dispatchers.IO){
            dayExerciseDao.insertExercise(exercise)
        }
    }

    fun deleteExercise(id:Int){
        coroutineScope.launch(Dispatchers.IO){
            dayExerciseDao.deleteExercise(id)
        }
    }
 }