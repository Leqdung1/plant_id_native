package com.example.myapplication.screen.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProfileScreen() {
    
}


@Composable
fun ProfileItem(
    title: String,
    icon: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.clickable { onClick() }

    ) {
        Text(
            text = icon
        )
        Text(
            text = title,

            )

    }
}
