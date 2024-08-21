package ui.elements

import assembly_files_logic.OpenedAssemblyFiles
import assembly_files_logic.chooseAndReadSFile
import ui.EncoderDecoderWindow

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
        ),
        TopAppBarButton(
            buttonText = "Encoder/Decoder",
            suboptions = listOf(Pair(if (!EncoderDecoderWindow.isOpened.value) "Open Window" else "Close Window") {
                EncoderDecoderWindow.isOpened.value = !EncoderDecoderWindow.isOpened.value
            })
        )
    )