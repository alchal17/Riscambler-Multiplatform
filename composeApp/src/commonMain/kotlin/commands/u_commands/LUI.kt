package commands.u_commands

import processing_tools.convertToDecimal
import memory.Registers

// load upper immediate
fun LUI(regs: Registers, operands: Map<String, String>) {
    val rd = convertToDecimal(operands["rd"]!!)
    val imm = convertToDecimal(operands["imm"]!!)

    val shiftedImm = imm shl 12
    regs.write(rd, shiftedImm)
}