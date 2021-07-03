package com.example.jacocoproject.repository

import com.example.jacocoproject.api.HelpApi
import com.example.jacocoproject.model.CountryModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class HelpRepositoryTest {
    @MockK
    private lateinit var api: HelpApi

    @InjectMockKs
    private lateinit var repository: HelpRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun onFetchData_withSuccess_returnRightData() {
        //Given
        coEvery { api.fetchData() } returns Response.success(mockList)

        //When
        val list = runBlocking { repository.fetchData() }.body()

        //Then
        Assert.assertNotNull(list)
        Assert.assertEquals("Brazil", list?.get(0)?.name)
        Assert.assertEquals("Belgica", list?.get(1)?.name)
    }

    @Test
    fun onFetchData_withError_returnRightData() {
        //Given
        coEvery { api.fetchData() } returns Response.error(
            403,
            ResponseBody.create(
                "application/json".toMediaTypeOrNull(),
                "{\"key\":[\"somestuff\"]}"
            )
        )


        //When
        val response = runBlocking { repository.fetchData() }

        //Then
        Assert.assertFalse(response.isSuccessful)
    }

    private val mockList = listOf(CountryModel(name = "Brazil"), CountryModel(name = "Belgica"))
}