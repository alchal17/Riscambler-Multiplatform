package commands.i_commands

import processing_tools.convertToDecimal
import memory.Registers


// set value of reg rd
// to 1 if reg value of rs1 is less than immediate value
// otherwise set to 0
fun SLTI(regs: Registers, operands: Map<String, String>) {
    val rd = convertToDecimal(operands["rd"]!!)
    val rs1 = convertToDecimal(operands["rs1"]!!)
    val imm = convertToDecimal(operands["imm"]!!)

    val data1 = regs.fetch(rs1)

    val result = if (data1 < imm) 1 else 0
    regs.write(rd, result)
}