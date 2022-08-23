package com.example.virginmoney.ui

import android.content.Context
import androidx.fragment.app.FragmentManager
import com.example.virginmoney.models.User
import com.example.virginmoney.ui.usersList.DetailDialogFragment
import com.example.virginmoney.ui.usersList.MainActivity
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Navigator @Inject constructor() {

    fun showUserList(context: Context) =
        context.startActivity(MainActivity.callingIntent(context))

    fun showUserDetails(fm: FragmentManager, user : User) =
        DetailDialogFragment.newInstance(user).show(fm, DetailDialogFragment.TAG)

}


