package translator

import processing_tools.convertToBinary
import processing_tools.trimLine

// pseudo instructions handler
class PIHandler {
    fun getComponents(codeLine: String): Pair<String, List<String>> {
        val trimmedLine = trimLine(codeLine)
        val splitComponents = trimmedLine.split(',')

        val instructionName = splitComponents[0].trim()
        val operands: MutableList<String> = ArrayList()

        for (component in splitComponents.drop(1)) {
            operands.add(convertToBinary(component))
        }

        return Pair(instructionName, operands)
    }
}