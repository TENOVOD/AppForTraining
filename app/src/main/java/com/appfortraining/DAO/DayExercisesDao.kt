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


    @Query("SELECT*FROM days WHERE day_id=:dayId")
    fun getDayWithExercise(dayId:Long):LiveData<List<DayWithExercises>>


}