package com.appfortraining.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "days")
data class Day(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "day_id")
    var dayId: Long = 0,

    @ColumnInfo(name = "day_date")
    var dayDate: String="",

    @ColumnInfo(name = "day_name")
    var dayName: String = "",

    @ColumnInfo(name = "is_workout_day")
    var isWorkoutDay: Boolean = false
)