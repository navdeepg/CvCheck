package com.cvcheck.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cvcheck.data.CVApi
import com.cvcheck.db.entity.Skill
import com.cvcheck.db.SkillRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SkillViewModel(application: Application) : AndroidViewModel(application) {

    private  var repository: SkillRepository = SkillRepository(application)
    var skillLiveData: LiveData<Skill> = repository.getAll()

    class Factory(private val application: Application) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return SkillViewModel(application) as T
        }
    }

    init {
        fetchSkills()
    }

    /**
     * Gets skill json using retrofit and store in room database
     */
    private fun fetchSkills() {
        val call = CVApi.singleton().skill()

        call.enqueue(object : Callback<Skill?> {
            override fun onResponse(call: Call<Skill?>, response: Response<Skill?>) {
                val skillVal = response.body() as Skill
                repository.insertSkill(skillVal)
            }

            override fun onFailure(call: Call<Skill?>, t: Throwable) {
                // Log error to paper-trail
            }
        })

    }

}