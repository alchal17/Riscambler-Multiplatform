package assembly_files_logic

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

object OpenedAssemblyFiles {
    private val _files: SnapshotStateList<AssemblyFile> = mutableStateListOf()

    val files: List<AssemblyFile>
        get() = _files

    fun addFile(assemblyFile: AssemblyFile) {
        _files.add(assemblyFile)
    }

    fun removeFile(assemblyFile: AssemblyFile) {
        _files.remove(assemblyFile)
    }
}