package com.example.uikit.composable

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.Pink3

/**
 * Индикатор текущей страницы
 * Дата создания: ДД-ММ-ГГГГ
 * Автор: № участника
 *
 * @param index индекс текущей страницы (1-3)
 */

@Composable
fun Pagination(
    index: Int
) {
    Log.d("Pagination", "[Pagination]: Отображение страницы - $index из 3")

    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(3) { i ->
            val isSelected = index == i + 1
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(if (isSelected) Pink3 else Pink3.copy(0.35f))
            )
        }
    }
}

@Preview
@Composable
private fun PaginationPreview() {
    Pagination(1)
}