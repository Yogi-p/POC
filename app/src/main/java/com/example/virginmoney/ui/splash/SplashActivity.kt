package com.example.virginmoney.ui.splash

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.virginmoney.R
import com.example.virginmoney.ui.Navigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT = 3000L

    @Inject
    internal lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen);

        Handler().postDelayed({
            navigator.showUserList(this)
            finish()
        }, SPLASH_TIME_OUT);
    }
}
