package commands.r_commands

import processing_tools.convertToDecimal
import memory.Registers

// set value of reg rd to 1 if reg value of rs1 is less than reg value of rs2
// otherwise set to 0
fun SLT(regs: Registers, operands: Map<String, String>) {
    val rd = convertToDecimal(operands["rd"]!!)
    val rs1 = convertToDecimal(operands["rs1"]!!)
    val rs2 = convertToDecimal(operands["rs2"]!!)

    val data1 = regs.fetch(rs1)
    val data2 = regs.fetch(rs2)

    val result = if (data1 < data2) 1 else 0
    regs.write(rd, result)
}