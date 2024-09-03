package processing_tools

/*
* Remove all unnecessary spaces from the code line
*/
fun trimLine(codeLine: String): String {
    return codeLine.replace(Regex("\\s+"), " ").trim()
}