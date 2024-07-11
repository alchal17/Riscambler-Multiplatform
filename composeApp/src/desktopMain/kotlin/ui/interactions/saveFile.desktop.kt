package ui.interactions

import java.io.File

actual fun saveFile(filePath: String, content: String) {
    try {
        File(filePath).writeText(content)
    } catch (e: Exception) {
        println("Failed to save content: ${e.message}")
    }
}
