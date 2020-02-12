package com.cvcheck.view.activities


import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import com.cvcheck.R


/**
 * This is base class to show splash screen
 */

class SplashActivity : BaseActivity() {
    // This is the loading time of the splash screen
    private val SPLASH_TIME_OUT:Long = 3000 // 3 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this,HomeActivity::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}
