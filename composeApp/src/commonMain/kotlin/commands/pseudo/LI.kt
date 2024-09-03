package commands.pseudo

import commands.i_commands.ADDI
import commands.u_commands.LUI
import memory.Registers

// Load immediate
fun LI(regs: Registers, operands: List<String>) {
    val rd = operands[0]
    val imm = operands[1]
    if (imm.length > 12) {
        LUI(regs, mapOf("rd" to rd, "imm" to imm))
        ADDI(regs, mapOf("rd" to rd, "rs1" to rd, "imm" to imm))
    } else {
        ADDI(regs, mapOf("rd" to rd, "rs1" to "00000", "imm" to imm))
    }
}