package ui.textFieldStyles

import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun getMainTextFieldColors() = TextFieldDefaults.textFieldColors(
    textColor = Color.White,
    unfocusedIndicatorColor = Color.Transparent,
    focusedIndicatorColor = Color.Transparent,
    backgroundColor = Color.Transparent
)