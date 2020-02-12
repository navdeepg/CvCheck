package com.cvcheck.view.activities

import android.os.Bundle
import com.cvcheck.R
import com.cvcheck.view.activities.BaseActivity

/**
 * Home activity that contains link to different menu options. It is also parent activity for all the fragments.
 */
class HomeActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}
