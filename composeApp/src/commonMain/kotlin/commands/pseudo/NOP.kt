package commands.pseudo

import commands.i_commands.ADDI
import memory.Registers

fun NOP(regs: Registers) {
    ADDI(regs, mapOf("rd" to "00000", "rs1" to "00000", "imm" to "0".repeat(12)))
}