package ui.interactions

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State

@Composable
expect fun isIconTinted(interactionSource: MutableInteractionSource): State<Boolean>