package memory

import processing_tools.convertToBinary

class Memory(totalSize: Int, textSize: Int) {
    // stores the instructions
    private val text = Array(textSize) { 0u }
    // stores data, variables, etc.
    // consists of data, heap and stack
    private val memory = ByteArray(totalSize)
    // pointers for memory
    private var textPointer = 0; // used to fill .text section
    // to be integrated later
    // private var heapPointer = 0;
    // private var stackPointer = memory.size;

    fun fetchInstruction(pc: Int): String {
        val firstByteLoc = pc

        val byte1 = text[firstByteLoc].toString()
        val byte2 = text[firstByteLoc + 1].toString()
        val byte3 = text[firstByteLoc + 2].toString()
        val byte4 = text[firstByteLoc + 3].toString()

        val binaryByte1 = convertToBinary(byte1)
        val binaryByte2 = convertToBinary(byte2)
        val binaryByte3 = convertToBinary(byte3)
        val binaryByte4 = convertToBinary(byte4)

        val paddedByte1 = binaryByte1.padStart(8, '0')
        val paddedByte2 = binaryByte2.padStart(8, '0')
        val paddedByte3 = binaryByte3.padStart(8, '0')
        val paddedByte4 = binaryByte4.padStart(8, '0')

        val instruction = paddedByte1 + paddedByte2 + paddedByte3 + paddedByte4
        return instruction
    }

    fun writeInstruction(instruction: UInt) {
        val bytes = listOf(
            (instruction shr 24) and 0xFFu,
            (instruction shr 16) and 0xFFu,
            (instruction shr 8) and 0xFFu,
            instruction and 0xFFu
        )

        for (byte in bytes) {
            text[textPointer++] = byte
        }
    }

    fun writeData(data: Byte, position: Int) {
        memory[position] = data
    }

    fun fetchData(position: Int): Byte {
        return memory[position]
    }

    fun getTextPointer(): Int {
        return textPointer
    }

    fun showTextContent() {
        var pointer = 0
        for (el in text) {
            println("Address " + pointer + ": " + text[pointer++])
        }
    }
}