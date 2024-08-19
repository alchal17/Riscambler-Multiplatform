package commands.i_commands

import data_converter.convertToDecimal
import memory.Registers


// set value of reg rd
// to 1 if unsigned reg value of rs1 is less than unsigned immediate value
// otherwise set to 0
fun SLTIU(regs: Registers, operands: Map<String, String>) {
    val rd = convertToDecimal(operands["rd"]!!)
    val rs1 = convertToDecimal(operands["rs1"]!!)
    val imm = convertToDecimal(operands["imm"]!!).toLong() and 0xFFFFFFFFL

    val data1 = regs.fetch(rs1).toLong() and 0xFFFFFFFFL

    val result = if (data1 < imm) 1 else 0
    regs.write(rd, result)
}