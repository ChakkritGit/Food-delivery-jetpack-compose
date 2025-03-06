package com.thanes.fooddelivery.data

import androidx.annotation.DrawableRes
import com.thanes.fooddelivery.R

data class ProductHighlightState(
    val text: String,
    val type: ProductHighlightType
)

enum class ProductHighlightType {
    PRIMARY, SECONDARY
}

data class ProductPreviewState(
    val headline: String = "Mr. Cheezy",
    @DrawableRes val productImg: Int = R.drawable.image_burger,
    val highlights: List<ProductHighlightState> = listOf(
        ProductHighlightState(
            text = "Classic Taste",
            type = ProductHighlightType.SECONDARY
        ),
        ProductHighlightState(
            text = "Bestseller",
            type = ProductHighlightType.PRIMARY
        )
    )
)