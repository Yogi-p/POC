package com.example.virginmoney.ui.usersList

import android.content.Context
import android.content.Intent
import com.example.virginmoney.base.BaseActivity
import com.example.virginmoney.ui.TabFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    companion object {
        fun callingIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun fragment() = TabFragment()
}
