package com.kudryavtsev.anton.core

class Accumulator {
    var x: Int = 0
    var y: Int = 0
    var value: Int = 0

    fun clear() {
        x = 0
        y = 0
        value = 0
    }

    override fun toString(): String {
        return "X=${Integer.toHexString(x)}\n" +
                "Y=${Integer.toHexString(y)}\n" +
                "A=${Integer.toHexString(value)}"
    }


}