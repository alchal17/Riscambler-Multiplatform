package commands.pseudo

import commands.b_commands.BLT
import memory.Registers
import processing_tools.convertToDecimal

fun BGTZ(pc: Int, regs: Registers, operands: List<String>) {
    val rs1 = operands[0]
    val offset = operands[1].padStart(12, '0')

    val data = regs.fetch(convertToDecimal(rs1))

    if (data > 0) {
        BLT(pc, regs, mapOf("rs1" to "00000", "rs2" to rs1, "imm" to offset))
    }
}