package com.appfortraining.models

import androidx.compose.ui.text.font.FontWeight
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "exercises")
data class Exercise(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "exercise_id")
    var exerciseId: Long = 0,

    @ColumnInfo(name = "exercise_name")
    var exerciseName: String = "",

    var repetitions: Int = 0,

    var weight: Float = 0F,

    @ColumnInfo(name = "duration")
    var duration: Int = 0,

    @ColumnInfo(name = "start_time")
    var startTime: Long = 0,

    @ColumnInfo(name = "end_time")
    var endTime: Long = 0,

    @ColumnInfo(name = "day_id")
    var dayId: Long = 0

) {

    constructor(exerciseName: String, repetitions: Int, dayId: Long) :
            this(0, exerciseName, repetitions, 0F, 0, System.currentTimeMillis() / 1000, 0, dayId)

    constructor(exerciseName: String, repetitions: Int, weight: Float, dayId: Long) :
            this(
                0,
                exerciseName,
                repetitions,
                weight,
                0,
                System.currentTimeMillis() / 1000,
                0,
                dayId
            )
}