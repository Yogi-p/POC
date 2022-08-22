package com.example.virginmoney.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.virginmoney.R
import dagger.hilt.android.AndroidEntryPoint
import inTransaction

@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
        addFragment(savedInstanceState)
    }

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(R.id.fragmentContainer) as BaseFragment).onBackPressed()
        super.onBackPressed()
    }

    private fun addFragment(savedInstanceState: Bundle?) =
        savedInstanceState ?: supportFragmentManager.inTransaction {
            add(R.id.fragmentContainer, fragment())
        }

    abstract fun fragment(): BaseFragment
}
