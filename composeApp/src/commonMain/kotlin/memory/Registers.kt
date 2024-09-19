package memory

import androidx.compose.runtime.mutableStateOf

object Registers {
    private val _registers = mutableStateOf(Array(32) { 0 })
    val registers: Array<Int>
        get() = _registers.value

    fun fetch(regNum: Int): Int {
        if (regNum < 0 || regNum >= _registers.value.size) {
            throw IndexOutOfBoundsException("Invalid register: $regNum")
        }
        return _registers.value[regNum]
    }

    fun write(regNum: Int, value: Int) {
        if (value in Int.MIN_VALUE..Int.MAX_VALUE) {
            if (regNum < 0 || regNum >= _registers.value.size) {
                throw IndexOutOfBoundsException("Invalid register: $regNum")
            }

            // Create a new array and update the state
            val newRegisters = _registers.value.copyOf() // Copy the current array
            newRegisters[regNum] = value // Modify the new array
            _registers.value = newRegisters // Assign new array to trigger recomposition
        } else {
            throw Exception("Assigned value should be no greater than 4 bytes")
        }
    }
}
