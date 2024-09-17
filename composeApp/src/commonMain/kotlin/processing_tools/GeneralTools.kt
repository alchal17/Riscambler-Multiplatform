package processing_tools

/*
* Remove all unnecessary spaces from the code line
*/
fun trimLine(codeLine: String): String {
    return codeLine.replace(Regex("\\s+"), " ").trim()
}

/*
* Accept whole user code and split it into sections
*/
fun splitCodeInSections(userCode: List<String>): Map<String, List<String>> {
    val sections = mutableMapOf<String, MutableList<String>>()
    var currentSection = ""

    for (line in userCode) {
        if (line.startsWith(".")) {
            // Save the previous section if it exists
            if (currentSection.isNotEmpty()) {
                // Initialize the list if it was not already initialized
                sections[currentSection] = sections.getOrPut(currentSection) { mutableListOf() }
            }
            // Start a new section
            currentSection = line.trim()
            // Ensure a new list is started for this section
            sections[currentSection] = mutableListOf()
        } else {
            // Add line to the current section
            if (currentSection.isNotEmpty()) {
                sections[currentSection]?.add(line)
            }
        }
    }

    // Handle the last section
    if (currentSection.isNotEmpty()) {
        sections[currentSection] = sections.getOrPut(currentSection) { mutableListOf() }
    }

    // Convert MutableList to List to match the return type
    return sections.mapValues { it.value.toList() }
}

fun splitDataSection(dataMap: List<String>): Map<String, Map<String, String>> {
    val updatedDataSection = mutableMapOf<String, Map<String, String>>();

    for (word in dataMap) {
        val splitElements = word.split(" ")
        var key = ""
        var dataType = ""
        val dataValues = mutableListOf<String>()
        for (el in splitElements) {
            if (el.contains(":")) {
                key = el.trim().replace(":", "")
            } else if (el.contains(".")) {
                dataType = el.trim().replace(".", "")
            } else {
                dataValues.add(el.trim())
            }
        }
        updatedDataSection[key] = mapOf(
            "type" to dataType,
            "value" to dataValues.toString()
        )
    }
    return updatedDataSection
}