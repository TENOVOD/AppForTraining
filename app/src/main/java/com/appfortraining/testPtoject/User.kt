package com.appfortraining.testPtoject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "users")
class User {


    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name="userId")
    var id:Int=0

    @ColumnInfo(name="userName")
    var name: String=""

    var age:Int=0

    constructor()
    constructor(name:String,age:Int){
        this.name=name
        this.age=age
    }


}