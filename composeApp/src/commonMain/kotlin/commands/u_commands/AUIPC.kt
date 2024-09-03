package commands.u_commands

import processing_tools.convertToDecimal
import memory.Registers

// add upper immediate to program counter
fun AUIPC(
    regs: Registers,
    operands: Map<String, String>,
    pc: Int) {
    val rd = convertToDecimal(operands["rd"]!!)
    val imm = convertToDecimal(operands["imm"]!!)

    val shiftedImm = imm shl 12
    val result = pc + shiftedImm

    regs.write(rd, result)
}