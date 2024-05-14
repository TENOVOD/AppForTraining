package com.appfortraining.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.appfortraining.models.Exercise

@Dao
interface ExerciseDao {

    @Query("SELECT*FROM exercises")
    fun getAllExercises(): LiveData<List<Exercise>>

    @Insert
    fun addExercise(exercise: Exercise)

    @Query("DELETE FROM exercises WHERE exercise_id=:id")
    fun deleteExercise(id:Int)

}