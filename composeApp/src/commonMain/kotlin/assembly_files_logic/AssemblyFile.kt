package assembly_files_logic

data class AssemblyFile(
    val fileName: String,
    val filePath: String,
    var fileContent: String
)