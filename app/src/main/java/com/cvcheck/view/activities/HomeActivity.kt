package com.cvcheck.view.activities

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cvcheck.R
import com.cvcheck.view.fragments.AboutFragment
import com.cvcheck.view.fragments.ExperienceFragment
import com.cvcheck.view.fragments.SkillFragment
import com.cvcheck.viewmodel.HomeViewModel
import com.cvcheck.viewmodel.HomeViewState
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Home activity that contains link to different menu options. It is also parent activity for all the fragments.
 */
class HomeActivity : BaseActivity(){
    private lateinit var mViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val factory = HomeViewModel.Factory(
            application)
        mViewModel = ViewModelProviders.of(this, factory).get(HomeViewModel::class.java)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        mViewModel.currentPageLiveData.observe(this, Observer {
            setState(it)
        })
        navView.setOnNavigationItemSelectedListener {
            mViewModel.changePage(it.itemId)
            true
        }
    }

    private fun setState(state: HomeViewState?) {
        state ?: return

        title = state.title
        val fragment = when(state.page) {
            HomeViewModel.Page.AboutMe -> AboutFragment.newInstance()
            HomeViewModel.Page.Experience -> ExperienceFragment.newInstance()
            HomeViewModel.Page.Skills -> SkillFragment.newInstance()
        }
        supportFragmentManager.beginTransaction().replace(R.id.container_layout, fragment).commit()
    }
}
