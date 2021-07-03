package com.example.jacocoproject.api

import com.example.jacocoproject.model.CountryModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface HelpApi {

    @Headers(
        "x-rapidapi-key:c22c596db7msh2b708b594284dadp104096jsned1a8a0f14f3",
        "x-rapidapi-host:restcountries-v1.p.rapidapi.com"
    )
    @GET("/all")
    suspend fun fetchData(): Response<List<CountryModel>>
}