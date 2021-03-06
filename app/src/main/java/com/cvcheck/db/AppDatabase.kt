package com.cvcheck.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.TypeConverters
import com.cvcheck.db.dao.AboutMeDao
import com.cvcheck.db.dao.ExperienceDao
import com.cvcheck.db.dao.SkillDao
import com.cvcheck.db.entity.*

@Database(
        entities = [(AboutMe::class), (Skill::class), (SkillType::class), (Experience::class), (ExperienceType::class)],
        version = 20

)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun aboutMeDao(): AboutMeDao
    abstract fun skillDao(): SkillDao
    abstract fun experienceDao(): ExperienceDao


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
