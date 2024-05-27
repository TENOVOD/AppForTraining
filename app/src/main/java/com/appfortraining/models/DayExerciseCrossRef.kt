package com.appfortraining.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "day_exercise_cross_ref",
    primaryKeys = ["day_id", "exercise_id"]
)
data class DayExerciseCrossRef(
    @ColumnInfo(name = "day_id")
    val dayId: Long = 0,
    @ColumnInfo(name = "exercise_id")
    val exerciseId: Long = 0
)