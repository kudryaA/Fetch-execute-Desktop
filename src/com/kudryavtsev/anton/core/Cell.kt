package com.kudryavtsev.anton.core

fun getCell(string: String, memory: Memory, accumulator: Accumulator): Int {
    val res: Int
    var buf: String = string
    when {
        string.contains("@") -> {
            buf = buf.replace("@", "")
            res = memory[Integer.parseInt(buf, 16) + accumulator.x]
        }
        string.contains("*") -> {
            buf = buf.replace("*", "")
            val buf = Integer.parseInt(buf, 16)
            res = memory[memory[buf]]
        }
        string.contains("#") -> {
            buf = buf.replace("#", "")
            val buf = java.lang.Integer.parseInt(buf, 16)
            res = buf
        }
        else -> {
            val buf = Integer.parseInt(buf, 16)
            res = memory[buf]
        }
    }

    return res
}