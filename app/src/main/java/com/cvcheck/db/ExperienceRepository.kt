package com.cvcheck.db

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.cvcheck.ApplicationData
import com.cvcheck.db.dao.ExperienceDao
import com.cvcheck.db.dao.SkillDao
import com.cvcheck.db.entity.Experience
import com.cvcheck.db.entity.Skill

class ExperienceRepository(application: Application) {
    private var experienceDao: ExperienceDao

    private var experience: LiveData<Experience>
    init {
        ApplicationData.getContext()
        val database: AppDatabase =  AppDatabase.getAppDatabase(application)
        experienceDao = database.experienceDao()
        experience = experienceDao.getAll()
    }

    fun insert(experience: Experience) {
        InsertAsyncTask(experienceDao).execute(experience)
    }

    fun delete() {
        DeleteAsyncTask(experienceDao).execute()
    }

    fun getAll(): LiveData<Experience> {
        return experience
    }

    private class InsertAsyncTask(experienceDao: ExperienceDao) : AsyncTask<Experience, Unit, Unit>() {
        val experienceDao = experienceDao

        override fun doInBackground(vararg p0: Experience?) {
            experienceDao.insert(p0[0]!!)
        }
    }

    private class DeleteAsyncTask(experienceDao: ExperienceDao) : AsyncTask<Unit, Unit, Unit>() {
        val experienceDao = experienceDao

        override fun doInBackground(vararg p0: Unit?) {
            experienceDao.delete()
        }
    }
}
