package com.cvcheck.db

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.cvcheck.ApplicationData
import com.cvcheck.db.dao.SkillDao
import com.cvcheck.db.entity.Skill

class SkillRepository(application: Application) {
    private var skillDao: SkillDao

    private var skill: LiveData<Skill>
    init {
        ApplicationData.getContext()
        val database: AppDatabase =  AppDatabase.getAppDatabase(application)
        skillDao = database.skillDao()
        skill = skillDao.getSkills()
    }

    fun insertSkill(skill: Skill) {
        InsertAsyncTask(skillDao).execute(skill)
    }

    fun delete() {
        DeleteAsyncTask(skillDao).execute()
    }

    fun getAll(): LiveData<Skill> {
        return skill
    }

    private class InsertAsyncTask(skillDao: SkillDao) : AsyncTask<Skill, Unit, Unit>() {
        val skillDao = skillDao

        override fun doInBackground(vararg p0: Skill?) {
            skillDao.insertSkill(p0[0]!!)
        }
    }

    private class DeleteAsyncTask(skillDao: SkillDao) : AsyncTask<Unit, Unit, Unit>() {
        val skillDao = skillDao

        override fun doInBackground(vararg p0: Unit?) {
            skillDao.deleteSkills()
        }
    }
}
