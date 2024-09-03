package commands.pseudo

import commands.r_commands.SUB
import memory.Registers

// Two's complement
fun NEG(regs: Registers, operands: List<String>) {
    val rd = operands[0]
    val rs = operands[1]

    SUB(regs, mapOf("rd" to rd, "rs1" to "00000", "rs2" to rs))
}