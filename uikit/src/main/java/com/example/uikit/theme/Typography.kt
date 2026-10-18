package com.example.uikit.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.uikit.R

/**
 * Текстовые стили
 * Дата создания: ДД-ММ-ГГГГ
 * Автор: № участника
 */

val Poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_extrabold, FontWeight.ExtraBold)
)

private object TextStyles {
    val title1 = TextStyle(fontSize = 24.sp, lineHeight = 28.sp)
    val title2 = TextStyle(fontSize = 20.sp, lineHeight = 28.sp)
    val title3 = TextStyle(fontSize = 17.sp, lineHeight = 24.sp)
    val headline = TextStyle(fontSize = 16.sp, lineHeight = 20.sp)
    val text = TextStyle(fontSize = 15.sp, lineHeight = 20.sp)
    val caption = TextStyle(fontSize = 14.sp, lineHeight = 20.sp)
    val caption2 = TextStyle(fontSize = 12.sp, lineHeight = 16.sp)
    val caption2Bold = TextStyle(fontSize = 12.sp, lineHeight = 20.sp)
}

// Типографика
data class Typography(
    val title1Semibold: TextStyle = TextStyles.title1.merge(
        TextStyle(fontFamily = Poppins, fontWeight = FontWeight.SemiBold)
    ),
    val title1Extrabold : TextStyle = TextStyles.title1.merge(
        TextStyle(fontFamily = Poppins, fontWeight = FontWeight.ExtraBold)
    ),
    val title2Regular: TextStyle = TextStyles.title2.merge(
        TextStyle(fontFamily = Poppins, fontWeight = FontWeight.Normal)
    ),
    val title2Semibold : TextStyle = TextStyles.title2.merge(
        TextStyle(fontFamily = Poppins, fontWeight = FontWeight.SemiBold)
    ),
    val title2Extrabold : TextStyle = TextStyles.title2.merge(
        TextStyle(fontFamily = Poppins, fontWeight = FontWeight.ExtraBold)
    ),
    val title3Regular : TextStyle = TextStyles.title3.merge(
        TextStyle(fontFamily = Poppins, fontWeight = FontWeight.Normal)
    ),
    val title3Medium : TextStyle = TextStyles.title3.merge(
        TextStyle(fontFamily = Poppins, fontWeight = FontWeight.Medium)
    ),
    val title3Semibold : TextStyle = TextStyles.title3.merge(
        TextStyle(fontFamily = Poppins, fontWeight = FontWeight.SemiBold)
    ),
    val headlineRegular: TextStyle = TextStyles.headline.merge(
        TextStyle(fontFamily = Poppins, fontWeight = FontWeight.Normal)
    ),
    val headlineMedium : TextStyle = TextStyles.headline.merge(
        TextStyle(fontFamily = Poppins, fontWeight = FontWeight.Medium)
    ),
    val textRegular : TextStyle = TextStyles.text.merge(
        TextStyle(fontFamily = Poppins, fontWeight = FontWeight.Normal)
    ),
    val textMedium : TextStyle = TextStyles.text.merge(
        TextStyle(fontFamily = Poppins, fontWeight = FontWeight.Medium)
    ),
    val captionRegular : TextStyle = TextStyles.caption.merge(
        TextStyle(fontFamily = Poppins, fontWeight = FontWeight.Normal)
    ),
    val captionSemibold : TextStyle = TextStyles.caption.merge(
        TextStyle(fontFamily = Poppins, fontWeight = FontWeight.SemiBold)
    ),
    val caption2Regular : TextStyle = TextStyles.caption2.merge(
        TextStyle(fontFamily = Poppins, fontWeight = FontWeight.Normal)
    ),
    val caption2Bold : TextStyle = TextStyles.caption2Bold.merge(
        TextStyle(fontFamily = Poppins, fontWeight = FontWeight.Bold)
    )
)

// Локальное хранилище
private val LocalTypography = staticCompositionLocalOf {
    Typography()
}

// Провайдер
@Composable
fun AppTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalTypography provides Typography(),
        content = content
    )
}

// Объект доступа
object Theme {
    val typography: Typography
        @Composable get() = LocalTypography.current
}