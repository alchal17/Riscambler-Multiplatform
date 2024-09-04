package commands.pseudo

import commands.i_commands.JALR
import commands.u_commands.AUIPC
import memory.Registers

fun CALL(pc: Int, regs: Registers, operands: List<String>) {
    val offset = operands[0]

    if (offset.length > 12) {
        val paddedOffset = offset.padStart(32, '0')
        val imm31_12 = paddedOffset.substring(0, 20)
        val imm11_0 = paddedOffset.substring(20, 31)
        AUIPC(regs, mapOf("rd" to "00001", "imm" to imm31_12), pc)
        JALR(pc, regs, mapOf("rd" to "00001", "rs1" to "00001", "imm" to imm11_0))
    } else {
        JALR(pc, regs, mapOf("rd" to "00001", "rs1" to "00001", "imm" to offset))
    }
}