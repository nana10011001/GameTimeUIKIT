package com.example.uikit.composable.inputs

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.composable.BottomSheet
import com.example.uikit.composable.PickerMode
import com.example.uikit.theme.Pink3
import com.example.uikit.theme.Poppins
import java.time.Instant
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

/**
 * Поле выбора даты или времени
 * Дата создания: ДД-ММ-ГГГГ
 * Автор: № участника
 *
 * @param title заголовок поля
 * @param mode режим выбора
 * @param datePickerState состояние выбора даты
 * @param timePickerState состояние выбора времени
 * @param placeholder значение по умолчанию
 * @param modifier модификатор поля
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Select(
    title: String,
    mode: PickerMode,
    datePickerState: DatePickerState? = null,
    timePickerState: TimePickerState? = null,
    placeholder: String,
    modifier: Modifier = Modifier
) {
    val showBottomSheet = remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val value = when (mode) {
        PickerMode.DATE ->
            datePickerState?.selectedDateMillis?.let {
                Instant.ofEpochMilli(it)
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate()
                    .format(DateTimeFormatter.ofPattern("EEE, MMM d, yyyy"))
                    .uppercase()
            } ?: placeholder

        PickerMode.TIME ->
            timePickerState?.let {
                LocalTime.of(it.hour, it.minute)
                    .format(DateTimeFormatter.ofPattern("hh:mm a"))
            } ?: placeholder
    }

    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 8.sp,
            color = Pink3
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 10.dp)
                .clickable {
                    showBottomSheet.value = !showBottomSheet.value
                    if (showBottomSheet.value) {
                        Log.i("Select", "[Select]: Открытие - ${
                                when (mode) {
                                    PickerMode.DATE -> "Выбор даты"
                                    PickerMode.TIME -> "Выбор времени"
                                }
                            }"
                        )
                    }
                }
        ) {
            Text(
                text = value,
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = Color.Black
            )
            Icon(
                painter = painterResource(R.drawable.dropdown),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(start = 16.dp)
            )
        }
    }

    if(showBottomSheet.value) {
        BottomSheet(
            onDismissRequest = {
                showBottomSheet.value = false
            },
            sheetState = sheetState,
            mode = mode,
            datePickerState = datePickerState,
            timePickerState = timePickerState
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun SelectDatePreview() {
    Select(
        title = "FROM",
        mode = PickerMode.DATE,
        datePickerState = rememberDatePickerState(),
        placeholder = "MON, NOV 4,2019"
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun SelectTimePreview() {
    Select(
        title = "",
        mode = PickerMode.TIME,
        timePickerState = rememberTimePickerState(),
        placeholder = "12:30 AM"
    )
}