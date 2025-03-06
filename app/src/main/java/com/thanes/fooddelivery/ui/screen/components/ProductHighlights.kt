package com.thanes.fooddelivery.ui.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.thanes.fooddelivery.data.ProductHighlightState
import com.thanes.fooddelivery.data.ProductHighlightType
import com.thanes.fooddelivery.ui.theme.AppTheme

@Composable
fun ProductHighlights(
    modifier: Modifier = Modifier, highlights: List<ProductHighlightState>
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        highlights.onEach { item ->
            Highlight(text = item.text, colors = HighlightDefaults.colors(type = item.type))
        }
    }
}

@Composable
private fun Highlight(
    modifier: Modifier = Modifier,
    text: String,
    colors: HighlightColors = HighlightDefaults.defaultsColors
) {
    Surface(
        modifier = Modifier,
        shape = RoundedCornerShape(percent = 50),
        contentColor = colors.contentColor,
        color = colors.containerColor
    ) {
        Box(
            modifier = Modifier.padding(
                vertical = 10.dp, horizontal = 12.dp
            )
        ) {
            Text(text = text, style = AppTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
        }
    }
}

private object HighlightDefaults {
    val defaultsColors = HighlightColors(
        contentColor = Color.Unspecified, containerColor = Color.Unspecified
    )

    @Composable
    fun colors(type: ProductHighlightType): HighlightColors = when (type) {
        ProductHighlightType.PRIMARY -> HighlightColors(
            containerColor = AppTheme.colors.highLightSurface,
            contentColor = AppTheme.colors.onHighLightSurface
        )

        ProductHighlightType.SECONDARY -> HighlightColors(
            containerColor = AppTheme.colors.actionSurface,
            contentColor = AppTheme.colors.onActionSurface
        )
    }
}

@Immutable
private data class HighlightColors(
    val containerColor: Color, val contentColor: Color
)