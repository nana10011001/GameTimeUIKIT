package com.example.uikit.composable

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * Нижняя модальная панель
 * Дата создания: ДД-ММ-ГГГГ
 * Автор: № участника
 *
 * @param onDismissRequest действие при закрытии панели
 * @param sheetState состояние нижней панели
 * @param mode режим выбора
 * @param datePickerState состояние выбора даты
 * @param timePickerState состояние выбора времени
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    onDismissRequest: () -> Unit,
    sheetState: SheetState,
    mode: PickerMode,
    datePickerState: DatePickerState? = null,
    timePickerState: TimePickerState? = null
) {
    ModalBottomSheet(
        onDismissRequest = {
            Log.i("BottomSheet", "[BottomSheet]: Закрытие")
            onDismissRequest()
        },
        sheetState = sheetState,
        containerColor = Color.White
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            when (mode) {
                PickerMode.DATE -> {
                    datePickerState?.let {
                        DatePicker(state = it)
                    }
                }

                PickerMode.TIME -> {
                    timePickerState?.let {
                        TimePicker(state = it)
                    }
                }
            }
        }
    }
}

enum class PickerMode {
    DATE,
    TIME
}