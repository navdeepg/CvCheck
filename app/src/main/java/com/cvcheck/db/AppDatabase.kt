package com.cvcheck.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.cvcheck.db.dao.AboutMeDao
import com.cvcheck.db.entity.AboutMe

@Database(
        entities = [(AboutMe::class)],
        version = 4

)
abstract class AppDatabase : RoomDatabase(){
    abstract fun aboutMeDao(): AboutMeDao


    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(this)
                {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "app-database")
                            // uncomment to allow queries on the main thread.
                            .fallbackToDestructiveMigration()
                                   .allowMainThreadQueries()
                            .build()
                }
            }
            return INSTANCE as AppDatabase
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
