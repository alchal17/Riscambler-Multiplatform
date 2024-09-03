package commands.pseudo

import commands.i_commands.ADDI
import commands.u_commands.AUIPC
import memory.Registers

// Load address
fun LA(pc: Int, regs: Registers, operands: List<String>) {
    val rd = operands[0]
    val imm12 = operands[1]
    val imm32 = imm12.padStart(32, '0')

    AUIPC(regs, mapOf("rd" to rd, "imm" to imm32), pc)
    ADDI(regs, mapOf("rd" to rd, "rs1" to rd, "imm" to imm12))
}