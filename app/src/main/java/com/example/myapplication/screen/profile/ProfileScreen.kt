package com.example.myapplication.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.CleaningServices
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.GppGood
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.NotificationsNone
import androidx.compose.material.icons.outlined.Policy
import androidx.compose.material.icons.outlined.PrivacyTip
import androidx.compose.material.icons.outlined.Subscriptions
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(
    onBack: () -> Unit = {},
    onEditProfile: () -> Unit = {},
    onSecurity: () -> Unit = {},
    onNotifications: () -> Unit = {},
    onPrivacy: () -> Unit = {},
    onMySubscription: () -> Unit = {},
    onHelpSupport: () -> Unit = {},
    onTermsPolicies: () -> Unit = {},
    onFreeUpSpace: () -> Unit = {},
    onDataSaver: () -> Unit = {},
) {
    val sections = listOf(
        SettingsSectionData(
            title = "Account",
            items = listOf(
                SettingsItemData("Edit profile", Icons.Outlined.Edit, onEditProfile),
                SettingsItemData("security", Icons.Outlined.Lock, onSecurity),
                SettingsItemData("Notifications", Icons.Outlined.NotificationsNone, onNotifications),
                SettingsItemData("Privacy", Icons.Outlined.PrivacyTip, onPrivacy),
            )
        ),
        SettingsSectionData(
            title = "Support & About",
            items = listOf(
                SettingsItemData("My Subscription", Icons.Outlined.Subscriptions, onMySubscription),
                SettingsItemData("Help & Support", Icons.Outlined.HelpOutline, onHelpSupport),
                SettingsItemData("Terms and Policies", Icons.Outlined.Policy, onTermsPolicies),
            )
        ),
        SettingsSectionData(
            title = "Cache & cellular",
            items = listOf(
                SettingsItemData("Free up space", Icons.Outlined.CleaningServices, onFreeUpSpace),
                SettingsItemData("Data Saver", Icons.Outlined.GppGood, onDataSaver),
            )
        ),
    )

    Surface(color = MaterialTheme.colorScheme.background) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentPadding = PaddingValues(bottom = 24.dp),
        ) {
            item {
                SettingsTopBar(
                    title = "Settings",
                    onBack = onBack,
                )
            }

            sections.forEach { section ->
                item {
                    SettingsSection(section)
                }
            }
        }
    }
}

private data class SettingsSectionData(
    val title: String,
    val items: List<SettingsItemData>,
)

private data class SettingsItemData(
    val title: String,
    val icon: ImageVector,
    val onClick: () -> Unit,
)

@Composable
private fun SettingsTopBar(
    title: String,
    onBack: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .height(44.dp)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterStart)
                .clickable(onClick = onBack)
                .padding(2.dp)
        )

        Text(
            text = title,
            modifier = Modifier.align(Alignment.Center),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            color = Color.Black,
        )
    }
}

@Composable
private fun SettingsSection(
    section: SettingsSectionData,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 10.dp)
    ) {
        Text(
            text = section.title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFF2F2F6),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(vertical = 6.dp)
        ) {
            section.items.forEachIndexed { index, item ->
                SettingsItemRow(
                    item = item,
                    showDivider = index != section.items.lastIndex,
                )
            }
        }
    }
}

@Composable
private fun SettingsItemRow(
    item: SettingsItemData,
    showDivider: Boolean,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = item.onClick)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = item.title,
                tint = Color(0xFF333333),
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.size(14.dp))

            Text(
                text = item.title,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black,
            )
        }

        if (showDivider) {
            Divider(
                modifier = Modifier.padding(start = 52.dp),
                color = Color(0x1A000000),
                thickness = 1.dp,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen()
}
