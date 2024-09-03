package processing_tools

fun toPower(base: Int, exp: Int): Int {
    return if (exp != 0) {
        base  * toPower(base, exp - 1)
    }
    else {
        1
    }
}

fun convertToDecimal(data: String): Int {
    val binaryNum = data.reversed()

    var powerOfTwo = 0
    var decimalNum = 0

    for (char in binaryNum) {
        decimalNum += char.toString().toInt() * toPower(2, powerOfTwo++)
    }

    return decimalNum
}