package commands.r_commands

import processing_tools.convertToDecimal
import memory.Registers

// shift right arithmetical: write rs1 >> rd2 to rd
// preserves the sign
fun SRA(regs: Registers, operands: Map<String, String>) {
    val rd = convertToDecimal(operands["rd"]!!)
    val rs1 = convertToDecimal(operands["rs1"]!!)
    val rs2 = convertToDecimal(operands["rs2"]!!)

    val data1 = regs.fetch(rs1)
    val data2 = regs.fetch(rs2)

    val result = data1 shr data2
    regs.write(rd, result)
}