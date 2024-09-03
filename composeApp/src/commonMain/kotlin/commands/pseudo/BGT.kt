package commands.pseudo

import commands.b_commands.BLT
import memory.Registers
import processing_tools.convertToDecimal

fun BGT(pc: Int, regs: Registers, operands: List<String>) {
    val rs1 = operands[0]
    val rs2 = operands[1]
    val offset = operands[2]

    val data1 = regs.fetch(convertToDecimal(rs1))
    val data2 = regs.fetch(convertToDecimal(rs2))

    if (data1 > data2) {
        BLT(pc, regs, mapOf("rs1" to rs2, "rs2" to rs1, "imm" to offset))
    }
}