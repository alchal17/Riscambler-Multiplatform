package commands.i_commands

import data_converter.convertToDecimal
import memory.Memory
import memory.Registers

// load half word (2 bytes / 16 bits) from memory
fun LH(memory: Memory, regs: Registers, operands: Map<String, String>) {
    val rd = convertToDecimal(operands["rd"]!!)
    val rs1 = convertToDecimal(operands["rs1"]!!)
    val imm = convertToDecimal(operands["imm"]!!)

    val dataAddress = regs.fetch(rs1) + imm

    val byte1 = memory.fetchData(dataAddress).toInt() and 0xFF
    val byte2 = memory.fetchData(dataAddress + 1).toInt() and 0xFF

    var fetchedData = (byte2 shl 8) or byte1

    if (fetchedData and (1 shl 0xF) != 0) {
        fetchedData = fetchedData or 0xFFFF0000.toInt()
    }

    regs.write(rd, fetchedData)
}