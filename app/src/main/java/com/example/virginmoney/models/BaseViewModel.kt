package com.example.virginmoney.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.virginmoney.exception.Failure

abstract class BaseViewModel : ViewModel() {

    private val _failure: MutableLiveData<Failure> = MutableLiveData()
    val failed: LiveData<Failure> = _failure

    protected fun handleFailure(failure: Failure) {
        _failure.value = failure
    }
}