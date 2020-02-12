package com.cvcheck.db

import android.app.Application
import androidx.lifecycle.LiveData
import android.os.AsyncTask
import android.util.Log
import com.cvcheck.ApplicationData
import com.cvcheck.db.dao.AboutMeDao
import com.cvcheck.db.entity.AboutMe

class DataRepository(application: Application) {
    private var aboutMeDao: AboutMeDao

    private var aboutMe: LiveData<AboutMe>
    init {
        ApplicationData.getContext()
        val database: AppDatabase =  AppDatabase.getAppDatabase(application)
        aboutMeDao = database.aboutMeDao()
        aboutMe = aboutMeDao.getAboutMe()
    }

    fun insertAbout(aboutMe: AboutMe) {
       InsertAboutAsyncTask(aboutMeDao).execute(aboutMe)
    }

    fun deleteAboutInfo() {
        DeleteAboutAsyncTask(aboutMeDao).execute()
    }

    fun getAboutInfo(): LiveData<AboutMe> {
        return aboutMe
    }

    private class InsertAboutAsyncTask(aboutMeDao: AboutMeDao) : AsyncTask<AboutMe, Unit, Unit>() {
        val aboutMeDao = aboutMeDao

        override fun doInBackground(vararg p0: AboutMe?) {
            aboutMeDao.insertAbout(p0[0]!!)
        }
    }

    private class DeleteAboutAsyncTask(aboutMeDao: AboutMeDao) : AsyncTask<Unit, Unit, Unit>() {
        val aboutMeDao = aboutMeDao

        override fun doInBackground(vararg p0: Unit?) {
            aboutMeDao.deleteAboutMe()
        }
    }
}
