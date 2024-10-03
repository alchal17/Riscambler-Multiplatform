package processing_tools

import constants.*
import memory.Memory
import memory.Registers
import translator.Decoder

val decoder = Decoder()

/*
* Remove all unnecessary spaces from the code line
*/
fun trimLine(codeLine: String): String {
    return codeLine.replace(Regex("\\s+"), " ").trim()
}

/*
* accept whole user code and split it into sections
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

/*
* split data segment into map where key is variable name
* value is type and variable value
*/
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

                        /*
* split text segment into map where key is function name, value is list of instructions
*/
fun splitTextSection(dataMap: List<String>): Map<String, List<String>> {
    val updatedTextSection = mutableMapOf<String, MutableList<String>>()

    var functionName = ""
    var instructions = mutableListOf<String>()

    for (el in dataMap) {
        if (el.contains(":")) {
            // If there's already a function being processed, add it to the map
            if (functionName.isNotEmpty()) {
                updatedTextSection[functionName] = instructions
            }

            // Set new function name and reset instructions
            functionName = el.trim().substringBefore(":")
            instructions = mutableListOf()
        } else {
            // Add instructions to the current function
            instructions.add(el.trim())
        }
    }

    // Add the last function and its instructions to the map
    if (functionName.isNotEmpty()) {
        updatedTextSection[functionName] = instructions
    }

    return updatedTextSection
}

/*
* Accept instruction name and process it by calling the corresponding implementation
*/
fun processInstruction(instruction: String, memory: Memory, regs: Registers, pc: Int) {
    val opcode = decoder.retrieveOpcode(instruction)
    val functs = decoder.retrieveFuncts(instruction)

    val instructionName = decoder.retrieveInstructionName(opcode, functs)
    val operands = decoder.retrieveOperands(instruction)
    val instructionNameLowerCase = instructionName.lowercase()

    when (instructionName) {
        in RiscVInstructions.typeR -> {
            instructionsTypeR[instructionNameLowerCase]?.invoke(regs, operands)
        }
        in RiscVInstructions.arithmeticTypeI -> {
            instructionsArithmeticTypeI[instructionNameLowerCase]?.invoke(regs, operands)
        }
        in RiscVInstructions.loadTypeI -> {
            instructionsLoadTypeI[instructionNameLowerCase]?.invoke(memory, regs, operands)
        }
        in RiscVInstructions.jalrTypeI -> {
            instructionsJalrTypeI[instructionNameLowerCase]?.invoke(pc, regs, operands)
        }
        in RiscVInstructions.typeS -> {
            instructionsTypeS[instructionNameLowerCase]?.invoke(memory, regs, operands)
        }
        in RiscVInstructions.typeB -> {
            instructionsTypeB[instructionNameLowerCase]?.invoke(pc, regs, operands)
        }
        in RiscVInstructions.typeU -> {
            when (instructionName) {
                "AUIPC" -> instructionsTypeU_AUIPC[instructionNameLowerCase]?.invoke(regs, operands, pc)
                "LUI" -> instructionsTypeU_LUI[instructionNameLowerCase]?.invoke(regs, operands)
            }
        }
        in RiscVInstructions.typeJ -> {
            instructionsTypeJ[instructionNameLowerCase]?.invoke(pc, regs, operands)
        }
        else -> {
            throw Exception("UCmd: $instructionName")
        }
    }
}