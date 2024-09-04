package commands.pseudo

import commands.b_commands.BGE
import memory.Registers
import processing_tools.convertToDecimal

fun BGEZ(pc: Int, regs: Registers, operands: List<String>) {
    val rs1 = operands[0]
    val offset = operands[1].padStart(12, '0')

    val data = regs.fetch(convertToDecimal(rs1))

    if (data >= 0) {
        BGE(pc, regs, mapOf("rs1" to rs1, "rs2" to "00000", "imm" to offset))
    }
}