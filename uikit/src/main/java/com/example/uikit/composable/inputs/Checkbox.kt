package com.example.uikit.composable.inputs

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R

/**
 * Чекбокс
 * Дата создания: ДД-ММ-ГГГГ
 * Автор: № участника
 *
 * @param value состояние чекбокса
 * @param onValueChange действие при нажатии
 * @param modifier модификатор чекбокса
 */

@Composable
fun Checkbox(
    value: Boolean,
    onValueChange: () -> Unit,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(
            id = if (value) {
                R.drawable.checkbox
            } else {
                R.drawable.checkbox_inactive
            }
        ),
        contentDescription = if (value) "active" else "inactive",
        modifier = modifier
            .size(14.dp)
            .clickable {
                Log.i("Checkbox", "[Checkbox]: Изменение состояния на ${!value}")
                onValueChange()
            }
    )
}

@Preview
@Composable
private fun CheckboxPreview() {
    val checkbox = remember { mutableStateOf(false) }

    Checkbox(
        value = checkbox.value,
        onValueChange = { checkbox.value = !checkbox.value }
    )
}