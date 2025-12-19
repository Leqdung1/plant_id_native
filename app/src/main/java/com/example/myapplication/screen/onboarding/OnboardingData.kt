package com.example.myapplication.screen.onboarding

import androidx.annotation.DrawableRes

data class OnboardingData (
    @DrawableRes val image: Int,
    val title: String,
    val description: String,
)