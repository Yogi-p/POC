package com.example.virginmoney.ui.usersList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.virginmoney.models.BaseViewModel
import com.example.virginmoney.models.User
import com.example.virginmoney.network.UseCase
import com.example.virginmoney.usecase.GetUsers
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(private val getUsers: GetUsers) : BaseViewModel() {

    private val _users: MutableLiveData<List<User>> = MutableLiveData()
    val users: LiveData<List<User>> = _users

    fun loadUsers() =
        getUsers(UseCase.None(), viewModelScope) { it.fold(::handleFailure, ::handleUserList) }

    private fun handleUserList(users: List<User>) {
        _users.value = users.map {
            User(it.id, it.createdAt, it.firstName, it.avatar, it.lastName, it.email,
            it.jobtitle,it.favouriteColor)
        }
    }
}