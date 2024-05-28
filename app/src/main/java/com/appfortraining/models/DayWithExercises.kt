package com.appfortraining.models

import androidx.lifecycle.LiveData
import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation


data class DayWithExercises(
    @Embedded val day: Day,
    @Relation(
        parentColumn = "day_id",
        entityColumn = "day_id"
    )
    val exercises: LiveData<List<Exercise>>
)
