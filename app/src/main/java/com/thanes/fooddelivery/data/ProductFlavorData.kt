package com.thanes.fooddelivery.data

import androidx.annotation.DrawableRes
import com.thanes.fooddelivery.R

data class ProductFlavorState(
    val name: String,
    val price: String,
    @DrawableRes val imgRes: Int
)

val ProductFlavorData = listOf(
    ProductFlavorState(
        imgRes = R.drawable.image_cheddar,
        name = "Cheddar",
        price = "$0.79"
    ),
    ProductFlavorState(
        imgRes = R.drawable.image_bacon,
        name = "Bacon",
        price = "$0.52"
    ),
    ProductFlavorState(
        imgRes = R.drawable.image_onion,
        name = "Onion",
        price = "$0.28"
    ),
)