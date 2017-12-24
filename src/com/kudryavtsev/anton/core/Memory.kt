package com.kudryavtsev.anton.core

class Memory {
    val data = HashMap<Int, Int>()

    fun add(index: Int, value: Int) {
        data.put(index, value)
    }

    operator fun get(index: Int): Int {
        if (data[index] == null) {
            data.put(index, 0)
        }
        return data[index]!!
    }
    operator fun set(index: Int, value: Int) {
        if (data[index] == null)
            data.put(index, value)
        else
            data[index] = value
    }

    fun clear() {
        data.clear()
    }
}