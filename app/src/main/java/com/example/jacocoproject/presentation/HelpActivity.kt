package com.example.jacocoproject.presentation

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.jacocoproject.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class HelpActivity : AppCompatActivity() {

    private val viewModel: HelpViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Check that CI holds lint exception

        bindElements()

        val button: Button = findViewById(R.id.test_button)
        button.setOnClickListener { requestData() }
    }

    private fun bindElements() {
        viewModel.liveData.observe(this, {
            when (it) {
                is HelpViewModel.HelpState.Success -> configureSuccess()
                is HelpViewModel.HelpState.Error -> configureError()
                is HelpViewModel.HelpState.Loading -> configureLoading()
            }
        })
    }

    private fun configureSuccess() {

    }

    private fun configureError() {

    }

    private fun configureLoading() {

    }

    private fun requestData() {
        viewModel.fetchData()
    }
}