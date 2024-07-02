package ui.interactions

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State

@Composable
actual fun isIconTinted(interactionSource: MutableInteractionSource): State<Boolean> {
    return interactionSource.collectIsHoveredAsState()
}