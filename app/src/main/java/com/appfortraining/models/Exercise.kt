package com.appfortraining.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName="exercises")
class Exercise {

    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name="exerciseId")
    var id:Int=0

    @ColumnInfo(name="exerciseName")
    var exerciseName:String = ""

    var repetitions:Int=0

    @ColumnInfo(name="exerciseTime")
    var time:Long=0
    constructor()
    constructor(exerciseName:String, repetitions:Int, time: Long){
        this.exerciseName=exerciseName
        this.repetitions=repetitions
        this.time=time
    }


}