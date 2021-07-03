package com.example.jacocoproject.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jacocoproject.business.HelpBusiness
import kotlinx.coroutines.launch

class HelpViewModel(private val business: HelpBusiness) : ViewModel() {

    private val mutableLiveData: MutableLiveData<HelpState> by lazy {
        MutableLiveData<HelpState>()
    }

    val liveData: LiveData<HelpState> = mutableLiveData

    fun fetchData() {
        viewModelScope.launch {
            try {
                mutableLiveData.value = HelpState.Loading

                val list = business.fetchData()

                if (list.isNullOrEmpty()) {
                    mutableLiveData.value = HelpState.Error
                } else {
                    Log.d("sm.borges", "your list: ${list}")
                    mutableLiveData.value = HelpState.Success
                }
            } catch (exception: Exception) {
                Log.d("sm.borges", "exception: ${exception}")
                mutableLiveData.value = HelpState.Error
            }
        }
    }

    sealed class HelpState {
        object Success : HelpState()
        object Loading : HelpState()
        object Error : HelpState()
    }
}