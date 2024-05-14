package com.appfortraining.models

import androidx.compose.ui.text.font.FontWeight
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName="exercises")
class Exercise {

    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name="exercise_id")
    var id:Int=0

    @ColumnInfo(name="exercise_name")
    var exerciseName:String = ""

    var repetitions:Int=0

    var weight: Float = 0F

    @ColumnInfo(name="duration")
    var duration:Int=0

    @ColumnInfo(name="start_time")
    var startTime: Long = 0

    @ColumnInfo(name = "end_time")
    var endTime:Long = 0


    constructor()
    constructor(exerciseName:String, repetitions:Int){
        this.exerciseName=exerciseName
        this.repetitions=repetitions
        this.startTime=System.currentTimeMillis()/1000
    }
    constructor(exerciseName:String, repetitions:Int,weight: Float){
        this.exerciseName=exerciseName
        this.repetitions=repetitions
        this.weight=weight
        this.startTime=System.currentTimeMillis()/1000
    }

}