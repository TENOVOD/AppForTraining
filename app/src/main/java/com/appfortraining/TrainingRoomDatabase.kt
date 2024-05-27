package com.appfortraining

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.appfortraining.DAO.DayExercisesDao
import com.appfortraining.models.Exercise

@Database(entities = [(Exercise::class)], version = 1)
abstract class TrainingRoomDatabase : RoomDatabase(){
    abstract fun exerciseDao():DayExercisesDao

    companion object{
        private var INSTANCE: TrainingRoomDatabase?=null

        fun getInstance(context: Context):TrainingRoomDatabase{
            synchronized(this){
                var instance= INSTANCE
                if(instance==null){
                    instance= Room.databaseBuilder(
                        context.applicationContext,
                        TrainingRoomDatabase::class.java,
                        "trainingdb"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE=instance
                }
                return instance
            }
        }
    }
}