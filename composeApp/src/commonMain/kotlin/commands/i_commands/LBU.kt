package commands.i_commands

import processing_tools.convertToDecimal
import memory.Memory
import memory.Registers

// load byte unsigned (1 byte / 8 bits) from memory
fun LBU(memory: Memory, regs: Registers, operands: Map<String, String>) {
    val rd = convertToDecimal(operands["rd"]!!)
    val rs1 = convertToDecimal(operands["rs1"]!!)
    val imm = convertToDecimal(operands["imm"]!!)

    val dataAddress = regs.fetch(rs1) + imm

    // Fetch one byte from memory
    val fetchedData = memory.fetchData(dataAddress).toInt() and 0xFF

    // Zero-extend the 8-bit value to 32 bits
    val zeroExtendedData = fetchedData and 0x000000FF

    // Write the zero-extended value into the register
    regs.write(rd, zeroExtendedData)
}
