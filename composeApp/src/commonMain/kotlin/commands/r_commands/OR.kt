package commands.r_commands

import processing_tools.convertToDecimal
import memory.Registers

// perform rs1 | rs2
// write results to rd
fun OR(regs: Registers, operands: Map<String, String>) {
    val rd = convertToDecimal(operands["rd"]!!)
    val rs1 = convertToDecimal(operands["rs1"]!!)
    val rs2 = convertToDecimal(operands["rs2"]!!)

    val data1 = regs.fetch(rs1)
    val data2 = regs.fetch(rs2)

    val result = data1 or data2
    regs.write(rd, result)
}