package com.example.virginmoney.ui.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.virginmoney.R
import com.example.virginmoney.base.BaseActivity
import com.example.virginmoney.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    companion object {
        fun callingIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun fragment() = UserListFragment()
}
