package commands.pseudo

import commands.i_commands.XORI
import memory.Registers

// One's complement
fun NOT(regs: Registers, operands: List<String>) {
    val rd = operands[0]
    val rs = operands[1]

    XORI(regs, mapOf("rd" to rd, "rs1" to rs, "imm" to "11111111111111111111111111111111"))
}