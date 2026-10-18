package com.example.uikit.composable

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.theme.Poppins

/**
 * Нижняя панель навигации приложения
 * Дата создания: ДД-ММ-ГГГГ
 * Автор: № участника
 *
 * @param currentScreen индекс текущего экрана
 * @param onStatisticsClick переход к экрану Statistics
 * @param onDiscoverClick переход к экрану Discover
 * @param onChatClick переход к экрану Chat
 * @param onProfileClick переход к экрану Profile
 * @param onLandingClick переход к экрану Landing
 * @param modifier модификатор панели
 */

@Composable
fun BottomBar(
    currentScreen: Int,
    onStatisticsClick: () -> Unit,
    onDiscoverClick: () -> Unit,
    onChatClick: () -> Unit,
    onProfileClick: () -> Unit,
    onLandingClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.bottombar),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .offset(y = (-30).dp)
        ) {
            BottomBarItem(
                enabled = currentScreen != 1,
                onClick = onStatisticsClick,
                icon = R.drawable.statistics,
                label = "Statistics",
                fontSize = 10.sp,
                modifier = Modifier.weight(1f)
            )
            BottomBarItem(
                enabled = currentScreen != 2,
                onClick = onDiscoverClick,
                icon = R.drawable.discover,
                label = "Discover",
                fontSize = 10.sp,
                modifier = Modifier.weight(1f)
            )
            Box(
                modifier = Modifier.weight(1f)
            )
            BottomBarItem(
                enabled = currentScreen != 3,
                onClick = onChatClick,
                icon = R.drawable.chat,
                label = "Chat",
                fontSize = 12.sp,
                modifier = Modifier.weight(1f)
            )
            BottomBarItem(
                enabled = currentScreen != 4,
                onClick = onProfileClick,
                icon = R.drawable.profile,
                label = "Profile",
                fontSize = 12.sp,
                modifier = Modifier.weight(1f)
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 15.dp)
                .size(56.dp)
                .border(
                    width = 5.dp,
                    color = Color.White,
                    shape = CircleShape
                )
                .clickable(
                    onClick = {
                        Log.i("BottomBar", "[BottomBar]: Навигация - Landing")
                        onLandingClick()
                    }
                )
        ) {
            Icon(
                painter = painterResource(R.drawable.calendar),
                contentDescription = "Calendar",
                tint = Color.Unspecified
            )
        }
    }
}

@Composable
private fun BottomBarItem(
    modifier: Modifier = Modifier,
    enabled: Boolean,
    onClick: () -> Unit,
    icon: Int,
    label: String,
    fontSize: TextUnit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .clickable(
                enabled = enabled,
                onClick = {
                    Log.i("BottomBar", "[BottomBar]: Навигация - $label")
                    onClick()
                }
            )
            .padding(horizontal = 2.dp)
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(24.dp)
        )
        Text(
            text = label,
            color = Color.White,
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            fontSize = fontSize,
            maxLines = 1,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun BottomBarPreview() {
    BottomBar(
        currentScreen = 1,
        onStatisticsClick = { },
        onDiscoverClick = { },
        onChatClick = { },
        onProfileClick = { },
        onLandingClick = { }
    )
}