package commands.i_commands

import processing_tools.convertToDecimal
import memory.Memory
import memory.Registers

// load halfword unsigned (2 bytes / 16 bits) from memory
fun LHU(memory: Memory, regs: Registers, operands: Map<String, String>) {
    val rd = convertToDecimal(operands["rd"]!!)
    val rs1 = convertToDecimal(operands["rs1"]!!)
    val imm = convertToDecimal(operands["imm"]!!)

    val dataAddress = regs.fetch(rs1) + imm

    // Fetch two bytes from memory
    val lowerByte = memory.fetchData(dataAddress).toInt() and 0xFF
    val upperByte = memory.fetchData(dataAddress + 1).toInt() and 0xFF

    // Combine them into a 16-bit value
    val fetchedData = (upperByte shl 8) or lowerByte

    // Zero-extend the 16-bit value to 32 bits
    val zeroExtendedData = fetchedData and 0x0000FFFF

    // Write the zero-extended value into the register
    regs.write(rd, zeroExtendedData)
}
