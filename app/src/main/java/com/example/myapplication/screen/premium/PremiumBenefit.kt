package com.example.myapplication.screen.premium

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@Composable
fun PremiumBenefit() {
    val benefit = listOf(
        BenefitData(
            icon = painterResource(id = R.drawable.ic_chat),
            title = "No Ads"
        )
    )
}

@Composable
fun ItemBenefit(
    icon: Painter,
    title: String,
) {
    Row(
        modifier = Modifier.padding(24.dp)
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.weight(1f)
        )
        Spacer(
            modifier = Modifier.width(12.dp)
        )
        Text(
            title,
            modifier = Modifier.weight(1f)
        )
    }
}