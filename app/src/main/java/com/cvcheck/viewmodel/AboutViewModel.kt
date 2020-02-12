package com.cvcheck.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cvcheck.data.CVApi
import com.cvcheck.db.DataRepository
import com.cvcheck.db.entity.AboutMe
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AboutViewModel(application: Application) : AndroidViewModel(application) {

    private  var repository: DataRepository = DataRepository(application)
    var aboutMeLiveData: LiveData<AboutMe> = repository.getAboutInfo()

    class Factory(private val application: Application) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return AboutViewModel(application) as T
        }
    }

    init {
        fetchAboutInfo()
    }

    /**
     * Gets about json using retrofit and store in room database
     */
    private fun fetchAboutInfo() {
        val call = CVApi.singleton().aboutMe()

        call.enqueue(object : Callback<AboutMe?> {
            override fun onResponse(call: Call<AboutMe?>, response: Response<AboutMe?>) {
                repository.insertAbout(response.body() as AboutMe)
            }

            override fun onFailure(call: Call<AboutMe?>, t: Throwable) {
                // Log error to paper-trail
                Log.e("Error", "error");
            }
        })

    }

}