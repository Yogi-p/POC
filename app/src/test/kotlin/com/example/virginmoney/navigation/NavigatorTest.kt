package com.example.virginmoney.navigation

import com.example.virginmoney.AndroidTest
import com.example.virginmoney.shouldNavigateTo
import com.example.virginmoney.ui.Navigator
import com.example.virginmoney.ui.splash.SplashActivity
import com.example.virginmoney.ui.usersList.MainActivity
import org.junit.Before
import org.junit.Test

class NavigatorTest : AndroidTest() {

    private lateinit var navigator: Navigator

    @Before fun setup() {
        navigator = Navigator()
    }

    @Test fun `User should be landed on user list screen`() {
        navigator.showUserList(context())
        SplashActivity::class shouldNavigateTo MainActivity::class
    }
}