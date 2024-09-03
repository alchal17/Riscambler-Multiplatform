package commands.i_commands

import processing_tools.convertToDecimal
import memory.Registers

fun JALR(pc: Int, regs: Registers, operands: Map<String, String>): Int {
    val rd = convertToDecimal(operands["rd"]!!)
    val rs1 = convertToDecimal(operands["rs1"]!!)
    val imm = convertToDecimal(operands["imm"]!!)

    val dataToStore = pc + 4
    regs.write(rd, dataToStore)

    val newPC = regs.fetch(rs1) + imm
    return newPC
}