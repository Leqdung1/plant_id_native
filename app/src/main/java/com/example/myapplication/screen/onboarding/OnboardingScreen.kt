package com.example.myapplication.screen.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(
    onFinish: () -> Unit
) {
    val pages = listOf(
        OnboardingData(
            R.drawable.img_ob1,
            "Accurate Plant Identifier",
            "Identify plants instantly with AI"
        ),

        OnboardingData(
             R.drawable.img_ob2,
             "Diagnose Plant Disease",
             "Detect disease and get solutions"
    )
    )

    val pageState = rememberPagerState { pages.size }

    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.height(600.dp)) {
        HorizontalPager(
            state = pageState,
            modifier = Modifier.weight(1f)
        ) {
            page -> OnboardingPage(pages[page])
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(
                onClick = onFinish
            ) {
                Text("Skip")
            }

            Button(
                onClick = {
                    scope.launch {
                        if (pageState.currentPage < pages.lastIndex) {
                            pageState.animateScrollToPage(
                                pageState.currentPage + 1
                            )
                        } else {
                            onFinish()
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                )
            ) {
                Text(
                    if (pageState.currentPage == pages.lastIndex)
                        "Get Started"
                    else
                        "Next"
                )
            }
        }
    }



}