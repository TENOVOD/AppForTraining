package com.appfortraining.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.appfortraining.models.Exercise

@Dao
interface DayExercisesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addExercise(exercise: Exercise)
}