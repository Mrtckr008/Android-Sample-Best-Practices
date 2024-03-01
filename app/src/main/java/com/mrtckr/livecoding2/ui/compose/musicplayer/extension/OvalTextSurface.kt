package com.mrtckr.livecoding2.ui.compose.musicplayer.extension

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OvalTextSurface(
    text: String,
    shape: Shape = RoundedCornerShape(50),
    isSelected: Boolean = false,
    onClick: () -> Unit
) {
    val backgroundColor =
        if (isSelected) MaterialTheme.colorScheme.onSecondary else MaterialTheme.colorScheme.secondary
    val textColor =
        if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSecondary

    Surface(
        modifier = Modifier
            .padding(4.dp)
            .clickable(onClick = onClick)
            .semantics { selected = isSelected },
        shape = shape,
        color = backgroundColor,
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            color = textColor
        )
    }
}

@Preview
@Composable
fun OvalTextSurfacePreview() {
    OvalTextSurface("All", isSelected = true, onClick = { })
}
