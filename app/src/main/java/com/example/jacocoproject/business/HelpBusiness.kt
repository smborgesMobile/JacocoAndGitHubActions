package com.example.jacocoproject.business

import android.util.Log
import com.example.jacocoproject.model.CountryModel
import com.example.jacocoproject.repository.HelpRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HelpBusiness(private val repository: HelpRepository) {
    suspend fun fetchData(): List<CountryModel>? = withContext(Dispatchers.IO) {
        Log.d("sm.borges", "Requesting")
        val data = repository.fetchData()

        if (data.isSuccessful) {
            data.body()
        } else {
            throw Exception()
        }
    }
}