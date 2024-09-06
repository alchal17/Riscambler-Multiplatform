package ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import assembly_files_logic.AssemblyFile
import assembly_files_logic.OpenedAssemblyFiles
import memory.Registers
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MainPageBody() {
    var terminalValue by remember { mutableStateOf("") }

    val files = OpenedAssemblyFiles.files

    Row(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.fillMaxHeight().width(2.dp).background(color = Color.Black))
        if (files.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Choose a file")
            }
        } else {
            Column {
                Box(modifier = Modifier.weight(3f)) {
                    Row(modifier = Modifier.fillMaxSize()) {
                        Box(modifier = Modifier.weight(3f)) { CodeSection() }
                        Box(modifier = Modifier.weight(1f)) { RegisterSection() }
                    }
                }
                Box(modifier = Modifier.weight(1f)) {
                    TerminalSection(terminalValue) { value: String ->
                        terminalValue = value
                    }
                }
            }
        }
    }
}