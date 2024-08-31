package commands.b_commands

import data_converter.convertToDecimal
import memory.Registers

fun BGE(pc: Int, regs: Registers, operands: Map<String, String>): Int {
    val rs1 = convertToDecimal(operands["rs1"]!!)
    val rs2 = convertToDecimal(operands["rs2"]!!)
    val imm = convertToDecimal(operands["imm"]!!)

    val data1 = regs.fetch(rs1)
    val data2 = regs.fetch(rs2)

    return if (data1 >= data2) pc + imm else pc
}