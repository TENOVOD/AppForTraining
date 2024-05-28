package com.appfortraining.repositories

import androidx.lifecycle.LiveData
import com.appfortraining.DAO.ExerciseDao
import com.appfortraining.models.Exercise
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExerciseRepository (
    private val exerciseDao: ExerciseDao

){
    private val coroutineScope=CoroutineScope(Dispatchers.Main)

    val exerciseList: LiveData<List<Exercise>> = exerciseDao.getAllExercises()

    fun addExercise(exercise: Exercise){
        coroutineScope.launch(Dispatchers.IO){
            exerciseDao.insertExercise(exercise)
        }
    }

    fun deleteExercise(id: Long){
        coroutineScope.launch(Dispatchers.IO){
            exerciseDao.deleteExercise(id)
        }
    }


 }