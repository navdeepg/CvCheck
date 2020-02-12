package com.cvcheck.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cvcheck.data.CVApi
import com.cvcheck.db.ExperienceRepository
import com.cvcheck.db.entity.Skill
import com.cvcheck.db.SkillRepository
import com.cvcheck.db.entity.Experience
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExperienceViewModel(application: Application) : AndroidViewModel(application) {

    private  var repository: ExperienceRepository = ExperienceRepository(application)
    var experienceLiveData: LiveData<Experience> = repository.getAll()

    class Factory(private val application: Application) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return ExperienceViewModel(application) as T
        }
    }

    init {
        fetchExperienceInfo()
    }

    /**
     * Gets experience json using retrofit and store in room database
     */
    private fun fetchExperienceInfo() {
        val call = CVApi.singleton().experience()

        call.enqueue(object : Callback<Experience?> {
            override fun onResponse(call: Call<Experience?>, response: Response<Experience?>) {
                val experienceVal = response.body() as Experience
                repository.insert(experienceVal)
            }

            override fun onFailure(call: Call<Experience?>, t: Throwable) {
                Log.e("Error", "##")
                // Log error to paper-trail
            }
        })

    }

}