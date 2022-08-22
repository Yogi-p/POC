package com.example.virginmoney.ui.rooms

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoney.R
import com.example.virginmoney.base.BaseFragment
import com.example.virginmoney.exception.Failure
import com.example.virginmoney.models.Rooms
import com.example.virginmoney.utils.common.invisible
import com.example.virginmoney.utils.common.visible
import dagger.hilt.android.AndroidEntryPoint
import failure
import kotlinx.android.synthetic.main.fragment_user_list.*
import observe
import javax.inject.Inject

@AndroidEntryPoint
class UserRoomFragment : BaseFragment() {

    @Inject
    lateinit var roomsAdapter: RoomsAdapter

    private val roomViewModel: RoomsViewModel by viewModels()

    override fun layoutId() = R.layout.fragment_user_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(roomViewModel) {
            observe(rooms, ::renderRoomList)
            failure(failed, ::handleFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        loadUserList()
    }


    private fun initializeView() {
        userList.layoutManager = LinearLayoutManager(context)
        userList.adapter = roomsAdapter
    }

    private fun loadUserList() {
        emptyView.invisible()
        userList.visible()
        showProgress()
        roomViewModel.loadRooms()
    }

    private fun renderRoomList(rooms: List<Rooms>?) {
        roomsAdapter.collection = rooms.orEmpty()
        hideProgress()
    }

    private fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.NetworkConnection -> renderFailure(R.string.failure_network_connection)
            is Failure.ServerError -> renderFailure(R.string.failure_server_error)
            is Failure.ListNotAvailable -> renderFailure(R.string.failure_user_list_unavailable)
            else -> renderFailure(R.string.failure_server_error)
        }
    }

    private fun renderFailure(@StringRes message: Int) {
        userList.invisible()
        emptyView.visible()
        hideProgress()
        notifyWithAction(message, R.string.action_refresh, ::loadUserList)
    }
}
