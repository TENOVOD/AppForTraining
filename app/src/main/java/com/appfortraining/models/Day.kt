package com.appfortraining.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName="days")
class Day {

    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name="day_id")
    var id:Int =0

    @ColumnInfo(name="unix_timestamp")
    var unixTimestamp:Long =0

    @ColumnInfo(name="day_name")
    var dayName:String=""

    @ColumnInfo(name="is_workout_day")
    var isWorkoutDay:Boolean = false

}