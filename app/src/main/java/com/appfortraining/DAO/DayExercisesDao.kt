package com.appfortraining.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.appfortraining.models.Day
import com.appfortraining.models.DayWithExercises
import com.appfortraining.models.Exercise

@Dao
interface DayExercisesDao {
//    @Insert
//    suspend fun insertDay(day: Day)
    @Insert
    suspend fun insertExercise(exercise: Exercise)

    @Query("SELECT*FROM exercises")
    fun getAllExercises(): LiveData<List<Exercise>>
//    @Query("SELECT*FROM days")
//    fun getAllDays(): LiveData<List<Day>>

//    @Query("SELECT*FROM days WHERE day_id=:dayId")
//    suspend fun getDayWithExercise(dayId:Long):LiveData<List<DayWithExercises>>

    @Query("DELETE FROM exercises WHERE exercise_id=:id")
    suspend fun deleteExercise(id:Int)
//    @Query("DELETE FROM days WHERE day_id=:id")
//    suspend fun deleteDay(id:Int)

}