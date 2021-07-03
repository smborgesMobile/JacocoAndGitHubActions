package com.example.jacocoproject.repository

import com.example.jacocoproject.api.HelpApi

class HelpRepository(private val api: HelpApi) {
    suspend fun fetchData() = api.fetchData()
}