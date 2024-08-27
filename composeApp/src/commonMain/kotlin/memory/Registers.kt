package memory

import androidx.compose.runtime.mutableStateOf

class Registers {
    private val _registers = mutableStateOf(Array(32) { 0 })
    val registers: Array<Int>
        get() = _registers.value

    init {
        _registers.value.fill(0)
    }

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
            _registers.value[regNum] = value
        } else {
            throw Exception("Assigned value should be no greater than 4 bytes")
        }

    }
}