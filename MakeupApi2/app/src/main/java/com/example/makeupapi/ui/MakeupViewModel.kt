package com.example.makeupapi.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.makeupapi.R
import com.example.makeupapi.data.network.Dashboardapi
import com.example.makeupapi.model.response.MakeupItem
import com.example.makeupapi.model.response.ProductColor
import com.example.makeupapi.utils.BaseViewModel
import com.example.makeupapi.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MakeupViewModel @Inject constructor(
    private val repository:Dashboardapi,
    application: Application
) : BaseViewModel(application) {


    private val mContext = application

    private val _allUsers = MutableLiveData<NetworkResult<List<MakeupItem>>>()
    val allUsers: LiveData<NetworkResult<List<MakeupItem>>>
        get() = _allUsers


    private val _allUsersproduct = MutableLiveData<NetworkResult<List<ProductColor>>>()
    val allUsersproduct: LiveData<NetworkResult<List<ProductColor>>>
        get() = _allUsersproduct

    init {
        showAPImakeup()
        showAPImakeups()
    }

    private fun showAPImakeup() {
        viewModelScope.launch {
            if (isConnected()) {
                _allUsers.value = NetworkResult.Loading()
                val response = repository.showAPImakeup()
                _allUsers.value = handleResponse(response)
            } else {
                _allUsers.value = NetworkResult.Error(
                    mContext.getString(R.string.no_internet)
                )
            }
        }
    }


    fun getdatafromApimakeup(query: String) {
        viewModelScope.launch {
            if (isConnected()) {
                _allUsers.value = NetworkResult.Loading()
                val response = repository.getdatafromApimakeup(query)
                _allUsers.value = handleResponse(response)
            } else {
                _allUsers.value = NetworkResult.Error(
                    mContext.getString(R.string.no_internet)
                )
            }
        }
    }


    private fun showAPImakeups() {
        viewModelScope.launch {
            if (isConnected()) {
                _allUsersproduct.value = NetworkResult.Loading()
                val response = repository.showAPImakeups()
                _allUsersproduct.value = handleResponse(response)
            } else {
                _allUsersproduct.value = NetworkResult.Error(
                    mContext.getString(R.string.no_internet)
                )
            }
        }
    }

}
