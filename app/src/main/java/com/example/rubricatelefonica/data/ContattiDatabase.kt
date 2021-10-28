package com.example.rubricatelefonica.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Contatto:: class], version=1, exportSchema = false)
abstract class ContattiDatabase : RoomDatabase() {
    abstract fun getRubricaDao(): RubricaDao
    companion object {
        @Volatile
        private var INSTANCE: ContattiDatabase? = null
        fun getInstance(context: Context): ContattiDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ContattiDatabase::class.java,
                        "rubrica_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries().build()

                    INSTANCE=instance

                }
                return instance
            }

        }
    }

}