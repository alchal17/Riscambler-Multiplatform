package commands.s_commands

import data_converter.convertToDecimal
import memory.Memory
import memory.Registers

fun SW(memory: Memory, regs: Registers, operands: Map<String, String>) {
    val rs1 = convertToDecimal(operands["rs1"]!!)
    val rs2 = convertToDecimal(operands["rs2"]!!)
    val imm = convertToDecimal(operands["imm"]!!)

    val storeAddress = regs.fetch(rs1) + imm
    val dataToStore = regs.fetch(rs2)

    val byte1 = (dataToStore and 0xFF).toByte()
    val byte2 = ((dataToStore shr 8) and 0xFF).toByte()
    val byte3 = ((dataToStore shr 16) and 0xFF).toByte()
    val byte4 = ((dataToStore shr 24) and 0xFF).toByte()

    memory.writeData(byte1, storeAddress)
    memory.writeData(byte2, storeAddress + 1)
    memory.writeData(byte3, storeAddress + 2)
    memory.writeData(byte4, storeAddress + 3)
}