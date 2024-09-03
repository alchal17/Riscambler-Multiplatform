package commands.i_commands

import processing_tools.convertToDecimal
import memory.Registers

// perform rs1 | imm12
// write results to rd
fun ORI(regs: Registers, operands: Map<String, String>) {
    val rd = convertToDecimal(operands["rd"]!!)
    val rs1 = convertToDecimal(operands["rs1"]!!)
    val imm = convertToDecimal(operands["imm"]!!)

    val data1 = regs.fetch(rs1)

    val result = data1 or imm
    regs.write(rd, result)
}