package commands.i_commands

import processing_tools.convertToDecimal
import memory.Registers

// shift right logical immediate: write rs1 >> shamt to rd
// shamt - bits[4:1] of imm
fun SRLI(regs: Registers, operands: Map<String, String>) {
    val rd = convertToDecimal(operands["rd"]!!)
    val rs1 = convertToDecimal(operands["rs1"]!!)
    val imm = convertToDecimal(operands["imm"]!!)

    val data1 = regs.fetch(rs1)
    val shamt = imm and 0b11111  // extract lower 5 bits

    val result = data1 shr shamt
    regs.write(rd, result)
}