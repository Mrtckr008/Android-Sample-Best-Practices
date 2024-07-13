package com.mrtckr.scrollboxesanimation

import android.content.Context
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.boundsInRoot
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DynamicBoxAnimator(
    primaryBoxContent: @Composable () -> Unit,
    secondaryBoxContent: @Composable () -> Unit,
    scrollState: ScrollState = rememberScrollState(),
    offsetDistanceDp: Dp = 50.dp,
    animationDuration: Int = 600,
    secondaryBoxTopPaddingDp: Dp = 230.dp,
    primaryBoxTopPaddingDp: Dp = 110.dp,
    scrollActivationThreshold: Float = 120f,
    secondaryBoxTopSpaceDp: Dp = 70.dp,
    syncScrollWithReduction: Boolean = false,
    scrollReductionFactor: Float = 2f
) {
    val context: Context = LocalContext.current
    val scrollableWidgetBounds = remember { mutableStateOf<Float?>(null) }
    val lastPointOfY = remember {
        mutableStateOf<Float?>(primaryBoxTopPaddingDp.value)
    }
    val scrollableWidgetTopPoint = scrollableWidgetBounds.value ?: 0f
    val shouldMoveUp = remember { mutableStateOf(false) }
    val currentInformationWidgetTranslationY = calculateCurrentInformationWidgetTranslationY(
        shouldMoveUp, offsetDistanceDp, animationDuration
    )
    val scrollFraction = scrollState.value / scrollReductionFactor

    Box(
        Modifier
            .padding(top = primaryBoxTopPaddingDp)
            .fillMaxWidth()
            .wrapContentHeight()
            .graphicsLayer {
                translationY = if (syncScrollWithReduction) {
                    if (shouldMoveUp.value) {
                        -lastPointOfY.value!!
                    } else {
                        lastPointOfY.value = scrollFraction
                        -scrollFraction
                    }
                } else {
                    currentInformationWidgetTranslationY
                }
            }) {
        shouldMoveUp.value = scrollableWidgetTopPoint < scrollActivationThreshold
        primaryBoxContent()
    }

    Box(
        Modifier
            .padding(top = secondaryBoxTopPaddingDp)
            .fillMaxWidth()
            .wrapContentHeight()
            .verticalScroll(scrollState)
            .testTag("ScrollableWidgetsBox")
    ) {
        Column {
            Spacer(modifier = Modifier.height(secondaryBoxTopSpaceDp))
            LineOfTopPoint(scrollableWidgetBounds, context)
            secondaryBoxContent()
        }
    }
}

@Composable
fun LineOfTopPoint(scrollableWidgetBounds: MutableState<Float?>, context: Context) {
    Box(modifier = Modifier
        .background(Color.Transparent)
        .fillMaxWidth()
        .alpha(0f)
        .height(1.dp)
        .onGloballyPositioned { coordinates ->
            val toDp = pxToDp(context, coordinates.boundsInRoot().top)
            scrollableWidgetBounds.value = toDp
        })
}

fun pxToDp(context: Context, px: Float): Float {
    return px / context.resources.displayMetrics.density
}

@Composable
fun calculateCurrentInformationWidgetTranslationY(
    shouldMoveUp: MutableState<Boolean>, toUpDp: Dp, animationDuration: Int
): Float {
    val currentInformationWidgetDistanceY = with(LocalDensity.current) {
        toUpDp.toPx()
    }
    return animateFloatAsState(
        targetValue = if (shouldMoveUp.value) -currentInformationWidgetDistanceY else 0f,
        animationSpec = tween(durationMillis = animationDuration),
        label = "CurrentInformationWidgetTranslationY"
    ).value
}
