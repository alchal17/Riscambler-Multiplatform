package ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ui.SecondaryBG
import ui.textFieldStyles.getMainTextFieldColors

@Composable
fun CodeSection(code: String, onCodeChange: (value: String) -> Unit) {
    Box(modifier = Modifier.fillMaxSize().background(color = SecondaryBG)) {
        TextField(
            value = code,
            onValueChange = onCodeChange,
            modifier = Modifier.fillMaxSize(),
            colors = getMainTextFieldColors()
        )
    }
}