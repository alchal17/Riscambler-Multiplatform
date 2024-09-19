package constants

import commands.r_commands.*
import commands.i_commands.*
import commands.s_commands.*
import commands.b_commands.*
import commands.u_commands.*
import commands.j_commands.*

import memory.Memory
import memory.Registers

val instructionsTypeR: Map<String, (Registers, Map<String, String>) -> Unit> = mapOf(
    "add" to ::ADD,
    "sub" to ::SUB,
    "and" to ::AND,
    "or" to ::OR,
    "xor" to ::XOR,
    "sll" to ::SLL,
    "slt" to ::SLT,
    "sltu" to ::SLTU,
    "sra" to ::SRA,
    "srl" to ::SRL
)

val instructionsArithmeticTypeI: Map<String, (Registers, Map<String, String>) -> Unit> = mapOf(
    "addi" to ::ADDI,
    "andi" to ::ANDI,
    "ori" to ::ORI,
    "xori" to ::XORI,
    "slli" to ::SLLI,
    "slti" to ::SLTI,
    "srli" to ::SRLI,
    "sltiu" to ::SLTIU,
    "srai" to ::SRAI,
)

val instructionsLoadTypeI: Map<String, (Memory, Registers, Map<String, String>) -> Unit> = mapOf(
    "lb" to ::LB,
    "lh" to ::LH,
    "lhu" to ::LHU,
    "lw" to ::LW,
)

val instructionsJalrTypeI: Map<String, (Int, Registers, Map<String, String>) -> Int> = mapOf(
    "jalr" to ::JALR,
)

val instructionsTypeS: Map<String, (Memory, Registers, Map<String, String>) -> Unit> = mapOf(
    "sb" to ::SB,
    "sh" to ::SH,
    "sw" to ::SW
)

val instructionsTypeB: Map<String, (Int, Registers, Map<String, String>) -> Int> = mapOf(
    "beq" to ::BEQ,
    "bge" to ::BGE,
    "bgeu" to ::BGEU,
    "blt" to ::BLT,
    "bltu" to ::BLTU,
    "bne" to ::BNE
)

val instructionsTypeU_AUIPC: Map<String, (Registers, Map<String, String>, Int) -> Unit> = mapOf(
    "auipc" to ::AUIPC
)

val instructionsTypeU_LUI: Map<String, (Registers, Map<String, String>) -> Unit> = mapOf(
    "lui" to ::LUI
)

val instructionsTypeJ: Map<String, (Int, Registers, Map<String, String>) -> Int> = mapOf(
    "jal" to ::JAL
)