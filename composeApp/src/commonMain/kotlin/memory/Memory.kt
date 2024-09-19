package memory

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

    fun fetchInstruction(pc: Int): UInt {
        val firstByteLoc = pc / 4

        val byte1 = text[firstByteLoc]
        val byte2 = text[firstByteLoc + 1]
        val byte3 = text[firstByteLoc + 2]
        val byte4 = text[firstByteLoc + 3]

        val instruction = (byte1 shl 24) or ((byte2 shl 16) or ((byte3 shl 8) or byte4))
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