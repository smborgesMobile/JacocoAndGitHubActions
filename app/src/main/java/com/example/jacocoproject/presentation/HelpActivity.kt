package com.example.jacocoproject.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jacocoproject.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class HelpActivity : AppCompatActivity() {

    private val viewModel: HelpViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Check that CI holds lint exception

        setContent {
            NewStory()
        }

        bindElements()
    }

    @Composable
    fun NewStory() {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = R.drawable.header),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.height(16.dp))
            Text(
                style = typography.h6,
                text = "The list of countries",
                overflow = TextOverflow.Ellipsis
            )
            Text(
                style = typography.body2,
                text = "What is your next trip?",
                maxLines = 2
            )
            Text(
                style = typography.body2,
                text = "Don't forgot to buy your ticket with us",
                maxLines = 2
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { requestData() }, modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Lets call the API.")
            }
        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        NewStory()
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