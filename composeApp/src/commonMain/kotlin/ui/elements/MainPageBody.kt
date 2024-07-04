package ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MainPageBody() {
    var codeValue by remember { mutableStateOf("") }
    var terminalValue by remember { mutableStateOf("") }
    Row(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.fillMaxHeight().width(2.dp).background(color = Color.Black))
        Column {
            Box(modifier = Modifier.weight(3f)) { CodeSection(codeValue) { value: String -> codeValue = value } }
            Box(modifier = Modifier.weight(1f)) {
                TerminalSection(terminalValue) { value: String ->
                    terminalValue = value
                }
            }
        }
    }
}