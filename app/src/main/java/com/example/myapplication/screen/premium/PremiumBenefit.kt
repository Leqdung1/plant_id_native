package com.example.myapplication.screen.premium

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@Composable
fun PremiumBenefit() {
    val benefit = listOf(
        BenefitData(
            icon = painterResource(id = R.drawable.ic_identify),
            title = "Identify 7,000+ plants & 100+ diseases with powerful AI"
        ),

        BenefitData(
            icon = painterResource(id = R.drawable.ic_chat),
            title = "24/7 expert help from your personal AI botanist"
        ),

        BenefitData(
            icon = painterResource(id = R.drawable.ic_alarm),
            title = "Unlimited care reminders – watering, fertilizing & more"
        ),

        BenefitData(
            icon = painterResource(id = R.drawable.ic_noads),
            title = "100% ad-free for uninterrupted plant care"
        )
    )

    Column() {

    }
}

@Composable
fun ItemBenefit(
    data: BenefitData
) {
    Row(
        modifier = Modifier.padding(24.dp)
    ) {
        Icon(
            painter = data.icon,
            contentDescription = null,
            modifier = Modifier.weight(1f)
        )
        Spacer(
            modifier = Modifier.width(12.dp)
        )
        Text(
            data.title,
            modifier = Modifier.weight(1f)
        )
    }
}