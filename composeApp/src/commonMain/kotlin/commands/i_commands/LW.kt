package commands.i_commands

import data_converter.convertToDecimal
import memory.Memory
import memory.Registers

// load word (4 bytes / 32 bits) from memory
fun LW(memory: Memory, regs: Registers, operands: Map<String, String>) {
    val rd = convertToDecimal(operands["rd"]!!)
    val rs1 = convertToDecimal(operands["rs1"]!!)
    val imm = convertToDecimal(operands["imm"]!!)

    val dataAddress = regs.fetch(rs1) + imm

    val byte1 = memory.fetchData(dataAddress).toInt() and 0xFF
    val byte2 = memory.fetchData(dataAddress + 1).toInt() and 0xFF
    val byte3 = memory.fetchData(dataAddress + 2).toInt() and 0xFF
    val byte4 = memory.fetchData(dataAddress + 3).toInt() and 0xFF

    val fetchedData = (byte4 shl 24) or (byte3 shl 16) or (byte2 shl 8) or byte1

    regs.write(rd, fetchedData)
}