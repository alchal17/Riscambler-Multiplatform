package commands.pseudo

import commands.j_commands.JAL
import memory.Registers

fun J(pc: Int, regs: Registers, operands: List<String>) {
    val offset = operands[0].padStart(20, '0')

    JAL(pc, regs, mapOf("rd" to "00000", "imm" to offset))
}