package com.example.jacocoproject.di

import com.example.jacocoproject.business.HelpBusiness
import com.example.jacocoproject.presentation.HelpViewModel
import com.example.jacocoproject.repository.HelpRepository
import com.example.jacocoproject.retrofit.RetrofitBuilder
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // ViewModel for Help View
    viewModel { HelpViewModel(get()) }

    //API
    single { RetrofitBuilder.create() }

    //Repository
    factory { HelpRepository(get()) }

    //Business
    factory { HelpBusiness(get()) }
}