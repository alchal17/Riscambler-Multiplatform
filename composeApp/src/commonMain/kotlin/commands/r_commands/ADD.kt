package commands.r_commands

import data_converter.convertToDecimal
import memory.Registers

// add content of regs rs1 and rs2
// write results to rd
fun ADD(regs: Registers, operands: Map<String, String>) {
    val rd = convertToDecimal(operands["rd"]!!)
    val rs1 = convertToDecimal(operands["s1"]!!)
    val rs2 = convertToDecimal(operands["rs2"]!!)

    val data1 = regs.fetch(rs1)
    val data2 = regs.fetch(rs2)

    val result = data1 + data2
    regs.write(rd, result)
}