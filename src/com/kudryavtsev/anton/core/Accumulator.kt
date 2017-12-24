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
        return "x=${Integer.toHexString(x)}\n" +
                "y=${Integer.toHexString(y)}\n" +
                "value=${Integer.toHexString(value)}"
    }


}