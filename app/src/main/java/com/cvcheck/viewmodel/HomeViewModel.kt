package com.cvcheck.viewmodel

import android.app.Application
import androidx.annotation.IdRes
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cvcheck.R

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    class Factory(private val application: Application) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return HomeViewModel(application) as T
        }
    }

    val currentPageLiveData = MutableLiveData<HomeViewState>()
        .apply { value = HomeViewState("AboutMe", Page.AboutMe) }


    fun changePage(@IdRes itemId: Int) {
        when(itemId) {
            R.id.tab_about_me -> currentPageLiveData.value = HomeViewState("AboutMe", Page.AboutMe)
            R.id.tab_experience -> currentPageLiveData.value = HomeViewState("Experience", Page.Experience)
            R.id.tab_skills -> currentPageLiveData.value = HomeViewState("Skills", Page.Skills)
        }
    }

    enum class Page {
        AboutMe, Experience, Skills
    }
}