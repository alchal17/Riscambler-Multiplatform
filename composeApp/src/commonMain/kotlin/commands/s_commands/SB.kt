package commands.s_commands

import data_converter.convertToDecimal
import memory.Memory
import memory.Registers

fun SB(memory: Memory, regs: Registers, operands: Map<String, String>) {
    val rs1 = convertToDecimal(operands["rs1"]!!)
    val rs2 = convertToDecimal(operands["rs2"]!!)
    val imm = convertToDecimal(operands["imm"]!!)

    val storeAddress = regs.fetch(rs1) + imm
    val dataToStore = regs.fetch(rs2)

    // Extract the least significant 8 bits (1 byte) from the dataToStore
    val byteToStore = (dataToStore and 0xFF).toByte()

    // Write the byte to memory
    memory.writeData(byteToStore, storeAddress)
}
