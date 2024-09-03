package commands.pseudo

import commands.i_commands.ADDI
import memory.Registers

// Copy register
fun MV(regs: Registers, operands: List<String>) {
    val rd = operands[0]
    val rs = operands[1]

    ADDI(regs, mapOf("rd" to rd, "rs1" to rs, "imm" to "00000000000000"))
}