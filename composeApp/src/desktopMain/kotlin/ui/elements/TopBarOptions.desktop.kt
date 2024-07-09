package ui.elements

import assembly_files_logic.OpenedAssemblyFiles
import assembly_files_logic.chooseAndReadSFile

actual val topAppBarOptions: List<TopAppBarButton>
    get() = listOf(
        TopAppBarButton(
            buttonText = "File",
            suboptions = listOf(
                Pair("Open file") {
                    val file = chooseAndReadSFile()
                    file?.let { OpenedAssemblyFiles.addFile(it) }
                },
                Pair("Open folder") {},
            )
        )
    )