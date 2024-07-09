package ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import assembly_files_logic.OpenedAssemblyFiles
import ui.MainBG
import ui.SecondaryBG
import ui.interactions.saveFile
import ui.textFieldStyles.getMainTextFieldColors

@Composable
fun CodeSection() {
    val fontSize = 20.sp
    var currentFile by remember { mutableStateOf(OpenedAssemblyFiles.files.last()) }
    var currentFileContent by remember { mutableStateOf(currentFile.fileContent) }
    Column(modifier = Modifier.fillMaxSize().background(color = SecondaryBG)) {
        Row(
            modifier = Modifier.fillMaxWidth().background(color = MainBG),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            OpenedAssemblyFiles.files.forEach { file ->
                FileMarker(
                    file = file,
                    onClick = {
                        currentFile = file
                        currentFileContent = file.fileContent
                    },
                    bgColor = if (currentFile == file) SecondaryBG else SecondaryBG.copy(alpha = 0.5f),
                    onCrossClick = {
                        OpenedAssemblyFiles.removeFile(file)
                        if (currentFile == file && OpenedAssemblyFiles.files.isNotEmpty()) {
                            currentFile = OpenedAssemblyFiles.files[0]
                            currentFileContent = currentFile.fileContent
                        }
                    }
                )
            }
        }
        TextField(
            value = currentFileContent,
            onValueChange = {
                currentFile.fileContent = it
                currentFileContent = it
                saveFile(currentFile.filePath, currentFile.fileContent)
            },
            modifier = Modifier.fillMaxSize(),
            colors = getMainTextFieldColors(),
            textStyle = TextStyle(fontSize = fontSize)
        )
    }
}

