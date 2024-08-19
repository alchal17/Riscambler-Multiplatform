package commands

import data_converter.convertToDecimal

fun fetchData(
    instructionType: String,
    operands: Map<String, String>): List<Int> {
    when (instructionType) {
        "R" -> {
            return listOf(
                convertToDecimal(operands["rd"]!!),
                convertToDecimal(operands["rs1"]!!),
                convertToDecimal(operands["rs2"]!!),
            )
        }
        "I" -> {
            return listOf(
                convertToDecimal(operands["rd"]!!),
                convertToDecimal(operands["rs1"]!!),
                convertToDecimal(operands["imm"]!!),
            )
        }
        "S" -> {
            return listOf(
                convertToDecimal(operands["rs1"]!!),
                convertToDecimal(operands["rs2"]!!),
                convertToDecimal(operands["imm"]!!),
            )
        }
        "B" -> {
            return listOf(
                convertToDecimal(operands["rs1"]!!),
                convertToDecimal(operands["rs2"]!!),
                convertToDecimal(operands["imm"]!!),
            )
        }
        "U" -> {
            return listOf(
                convertToDecimal(operands["rd"]!!),
                convertToDecimal(operands["imm"]!!),
            )
        }
        "J" -> {
            return listOf(
                convertToDecimal(operands["rd"]!!),
                convertToDecimal(operands["imm"]!!),
            )
        }
        else -> {
            throw Exception("UCmd Type: $instructionType")
        }
    }
}