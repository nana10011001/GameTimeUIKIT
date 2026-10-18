package com.example.uikit.composable.inputs

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.theme.HorizontalGradient
import com.example.uikit.theme.Poppins

/**
 * Текстовое поле с плейсхолдером и опциональным переключением видимости
 * Дата создания: ДД-ММ-ГГГГ
 * Автор: № участника
 *
 * @param value введенный текст
 * @param onValueChange обработчик изменения текста
 * @param placeholder плейсхолдер
 * @param isPassword отображение иконки видимости
 * @param modifier модификатор поля
 */

@Composable
fun Input(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false,
    modifier: Modifier = Modifier
) {
    val visualTransformation = remember { mutableStateOf(true) }

    BasicTextField(
        value = value,
        onValueChange = {
            Log.d("Input", "[Input]: Ввод текста - Изменение длины на ${it.length}")
            onValueChange(it)
        },
        visualTransformation = if (isPassword && visualTransformation.value) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        modifier = modifier,
        decorationBox = { innerTextField ->
            Column {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                color = Color.Black
                            )
                        }
                        innerTextField()
                    }

                    if (isPassword) {
                        Icon(
                            painter = painterResource(R.drawable.invisible),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .clickable {
                                    visualTransformation.value = !visualTransformation.value
                                    Log.i("Input", "[Input]: Видимость текста - ${if (visualTransformation.value) "Скрыт" else "Показан"}")
                                }
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(brush = HorizontalGradient)
                )
            }
        }
    )
}

@Preview
@Composable
private fun InputPreview() {
    val fullName = remember { mutableStateOf("") }

    Input(
        value = fullName.value,
        onValueChange = { fullName.value = it },
        placeholder = "Full Name",
        isPassword = false,
        modifier = Modifier
            .padding(horizontal = 20.dp)
    )
}

@Preview
@Composable
private fun InputPasswordPreview() {
    val password = remember { mutableStateOf("") }

    Input(
        value = password.value,
        onValueChange = { password.value = it },
        placeholder = "Password",
        isPassword = true,
        modifier = Modifier
            .padding(horizontal = 20.dp)
    )
}