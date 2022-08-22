package com.example.virginmoney.ui

import android.content.Context
import com.example.virginmoney.ui.usersList.MainActivity
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Navigator @Inject constructor() {

    fun showUserList(context: Context) =
        context.startActivity(MainActivity.callingIntent(context))

}


