package com.example.myapplication.screen.home

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardOption(
    data: DataOption,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val colorBorder = if (!isSelected)
        Color(0xFFF7F7F7)
    else Color(0xFF008E53)

    val colorBackground = if (isSelected)
        Color(0xFFF0FFEC)
    else Color(0xFFEEEEEE)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .border(1.dp, colorBorder, RoundedCornerShape(12.dp)),

        colors = CardDefaults.cardColors(
            containerColor = colorBackground
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
        ) {
            Text(
                text = data.title,
                color = Color(0xFF021C11),
                fontSize = 17.sp,
                fontWeight = FontWeight.Normal
            )
            Spacer(
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(
                text = data.description,
                color = Color(0xFF021C11),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}