package com.example.myapplication.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun OnboardingPage(data: OnboardingData) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Spacer(modifier = Modifier.height(40.dp))
        Image(
            painter = painterResource(id = data.image),
            contentDescription = null,
            modifier = Modifier.height(300.dp).fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = data.title,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = data.description,
            textAlign = TextAlign.Center
        )

    }
}