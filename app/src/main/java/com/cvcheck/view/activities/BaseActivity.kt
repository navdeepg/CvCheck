package com.cvcheck.view.activities

import androidx.appcompat.app.AppCompatActivity

/**
 * Base activity to be extended by all the activities. We should have common shared function activities here.
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }
}
