package com.example.virginmoney.ui.rooms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.virginmoney.models.BaseViewModel
import com.example.virginmoney.models.Rooms
import com.example.virginmoney.models.User
import com.example.virginmoney.network.UseCase
import com.example.virginmoney.usecase.GetRooms
import com.example.virginmoney.usecase.GetUsers
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RoomsViewModel @Inject constructor(private val getRooms: GetRooms) : BaseViewModel() {

    private val _rooms: MutableLiveData<List<Rooms>> = MutableLiveData()
    val rooms: LiveData<List<Rooms>> = _rooms

    fun loadRooms() =
        getRooms(UseCase.None(), viewModelScope) { it.fold(::handleFailure, ::handleRoomsList) }

    private fun handleRoomsList(rooms: List<Rooms>) {
        _rooms.value = rooms.map {
            Rooms(it.id, it.createdAt, it.isOccupied,it.maxOccupancy)
        }
    }
}