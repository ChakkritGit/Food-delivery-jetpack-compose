package com.thanes.fooddelivery.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.thanes.fooddelivery.data.OrderData
import com.thanes.fooddelivery.data.OrderState
import com.thanes.fooddelivery.data.ProductDescriptionData
import com.thanes.fooddelivery.data.ProductFlavorData
import com.thanes.fooddelivery.data.ProductFlavorState
import com.thanes.fooddelivery.data.ProductNutritionData
import com.thanes.fooddelivery.data.ProductNutritionState
import com.thanes.fooddelivery.data.ProductPreviewState
import com.thanes.fooddelivery.ui.screen.components.FlavorSection
import com.thanes.fooddelivery.ui.screen.components.OrderActionBar
import com.thanes.fooddelivery.ui.screen.components.ProductDescriptionSection
import com.thanes.fooddelivery.ui.screen.components.ProductNutritionSection
import com.thanes.fooddelivery.ui.screen.components.ProductPreviewSection

@Composable
fun ProductDetailScreen(
    modifier: Modifier = Modifier,
    productPreviewState: ProductPreviewState = ProductPreviewState(),
    productFlavors: List<ProductFlavorState> = ProductFlavorData,
    productNutritionState: ProductNutritionState = ProductNutritionData,
    productDescription: String = ProductDescriptionData,
    orderState: OrderState = OrderData,
    onAddItemClicked: () -> Unit = {},
    onRemoveItemClicked: () -> Unit = {},
    onCheckOutClicked: () -> Unit = {}
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Content(
            productDescription = productDescription,
            productFlavors = productFlavors,
            productNutritionState = productNutritionState,
            productPreviewState = productPreviewState,
        )
        OrderActionBar(
            state = orderState,
            onAddItemClicked = onAddItemClicked,
            onRemoveItemClicked = onRemoveItemClicked,
            onCheckOutClicked = onCheckOutClicked,
            modifier = Modifier
                .navigationBarsPadding()
                .padding(
                    horizontal = 18.dp,
                    vertical = 8.dp
                )
        )
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    productPreviewState: ProductPreviewState,
    productFlavors: List<ProductFlavorState>,
    productNutritionState: ProductNutritionState,
    productDescription: String
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier.verticalScroll(scrollState)
    ) {
        ProductPreviewSection(
            state = productPreviewState
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        FlavorSection(
            data = productFlavors,
            modifier = Modifier.padding(horizontal = 18.dp)
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        ProductNutritionSection(
            state = productNutritionState,
            modifier = Modifier.padding(horizontal = 18.dp)
        )
        Spacer(
            modifier = Modifier.height(32.dp)
        )
        ProductDescriptionSection(
            productDescription = productDescription,
            modifier = Modifier
                .navigationBarsPadding()
                .padding(horizontal = 18.dp)
                .padding(bottom = 128.dp)
        )
    }
}