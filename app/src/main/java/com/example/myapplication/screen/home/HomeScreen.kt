package com.example.myapplication.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    onClose: () -> Unit
) {
    val options = listOf(
        DataOption(1, "Don't know the plant name", "Want to identify the plant accurately."),
        DataOption(
            2,
            "Leaves are wilting or turning yellow",
            "Concerned the plant may have an issue."
        ),
        DataOption(3, "Often forget to water", "Need timely care reminders."),
        DataOption(4, "Want to create a greener home", "Looking for plants that fit your space.")
    )

    var selectedId by remember { mutableStateOf<Int?>(null) }

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        onClose()
                    }
            )
        }


        Text(
            text = "What is the biggest problem you are facing?",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Black,
        )
        Spacer(
            Modifier.height(height = 12.dp)
        )
        Text(
            text = "Help us make more suitable suggestions.",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF9BA09F)
        )
        Spacer(
            modifier = Modifier.height(28.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(options) { option ->
                CardOption(
                    data = option,
                    isSelected = option.id == selectedId,
                    onClick = {
                        selectedId = option.id
                    }
                )
            }
        }
    }


}