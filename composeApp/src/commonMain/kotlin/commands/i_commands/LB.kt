package commands.i_commands

import data_converter.convertToDecimal
import memory.Memory
import memory.Registers

// load byte (8 bits) from memory
fun LB(memory: Memory, regs: Registers, operands: Map<String, String>) {
    val rd = convertToDecimal(operands["rd"]!!)
    val rs1 = convertToDecimal(operands["rs1"]!!)
    val imm = convertToDecimal(operands["imm"]!!)

    val dataAddress = regs.fetch(rs1) + imm

    var fetchedData = memory.fetchData(dataAddress).toInt() and 0xFF

    if (fetchedData and (1 shl 7) != 0) {
        fetchedData = fetchedData or 0xFFFFFF00.toInt()
    }

    regs.write(rd, fetchedData)
}