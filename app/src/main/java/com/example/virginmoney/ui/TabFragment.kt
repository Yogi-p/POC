package com.example.virginmoney.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.virginmoney.R
import com.example.virginmoney.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_tab_view.*

@AndroidEntryPoint
class TabFragment : BaseFragment() {

    override fun layoutId() = R.layout.fragment_tab_view

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = requireActivity().findNavController(R.id.nav_fragment)
        bottom_navigation_view.setupWithNavController(navController)
    }

}