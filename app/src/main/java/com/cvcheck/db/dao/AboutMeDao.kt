package com.cvcheck.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cvcheck.db.entity.AboutMe

@Dao
interface AboutMeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAbout(aboutMe: AboutMe)

    @Query("DELETE FROM about_table")
    fun deleteAboutMe()

    @Query("SELECT * FROM about_table")
    fun getAboutMe(): LiveData<AboutMe>

}
