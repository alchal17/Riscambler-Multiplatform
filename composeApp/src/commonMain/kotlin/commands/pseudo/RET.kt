package commands.pseudo

import commands.i_commands.JALR
import memory.Registers

fun RET(pc: Int, regs: Registers) {
    JALR(pc, regs, mapOf("rd" to "00000", "rs1" to "00001", "imm" to "0".repeat(12)))
}