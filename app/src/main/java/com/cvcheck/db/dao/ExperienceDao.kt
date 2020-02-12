package com.cvcheck.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cvcheck.db.entity.AboutMe
import com.cvcheck.db.entity.Experience
import com.cvcheck.db.entity.Skill

@Dao
interface ExperienceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(experience: Experience)

    @Query("DELETE FROM experience_table")
    fun delete()

    @Query("SELECT * FROM experience_table")
    fun getAll(): LiveData<Experience>

}
