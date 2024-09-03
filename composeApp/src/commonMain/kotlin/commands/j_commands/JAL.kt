package commands.j_commands

import processing_tools.convertToDecimal
import memory.Registers

fun JAL(pc: Int, regs: Registers, operands: Map<String, String>): Int {
    val rd = convertToDecimal(operands["rd"]!!)
    val imm = convertToDecimal(operands["imm"]!!)

    val dataToStore = pc + 4
    regs.write(rd, dataToStore)

    val newPC = pc + imm
    return newPC
}