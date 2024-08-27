package assembly_files_logic

import javax.swing.JFileChooser
import javax.swing.filechooser.FileNameExtensionFilter

actual fun chooseAndReadSFile(): AssemblyFile? {
    val fileChooser = JFileChooser()
    fileChooser.fileFilter = FileNameExtensionFilter("Assembly Files", "rsv")

    val result = fileChooser.showOpenDialog(null)
    if (result == JFileChooser.APPROVE_OPTION) {
        val selectedFile = fileChooser.selectedFile
        return AssemblyFile(
            fileName = selectedFile.name,
            filePath = selectedFile.absolutePath,
            fileContent = selectedFile.readText()
        )
    }
    return null

}