package com.cvcheck.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cvcheck.db.entity.AboutMe
import com.cvcheck.db.entity.Skill

@Dao
interface SkillDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSkill(skill: Skill)

    @Query("DELETE FROM skill_table")
    fun deleteSkills()

    @Query("SELECT * FROM skill_table")
    fun getSkills(): LiveData<Skill>

}
