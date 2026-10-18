package com.example.uikit.composable.buttons

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.theme.Poppins
import com.example.uikit.theme.VerticalGradient

/**
 * Основная кнопка
 * Дата создания: ДД-ММ-ГГГГ
 * Автор: № участника
 *
 * @param text текст кнопки
 * @param onCLick действие при нажатии
 * @param modifier модификатор кнопки
 */

@Composable
fun PrimaryButton(
    onCLick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {
            Log.i("PrimaryButton", "[PrimaryButton]: Нажатие - $text")
            onCLick()
        },
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color.Transparent
        ),
        modifier = modifier
            .height(58.dp)
            .widthIn(210.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(brush = VerticalGradient)
    ) {
        Text(
            text = text,
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }
}

@Preview
@Composable
private fun PrimaryButtonPreview() {
    PrimaryButton(
        onCLick = { },
        text = "Let’s Combat!"
    )
}