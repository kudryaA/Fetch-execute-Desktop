package com.kudryavtsev.anton.design.controller

import com.kudryavtsev.anton.core.Accumulator
import com.kudryavtsev.anton.core.Memory
import com.kudryavtsev.anton.core.getCell
import com.kudryavtsev.anton.design.messages.responseIntHex
import javafx.fxml.FXML
import javafx.scene.control.ListView
import javafx.scene.control.TextArea

class Window {

    @FXML
    private var textCode: TextArea? = null

    @FXML
    private var textConsole: TextArea? = null

    @FXML
    private var textAccumulator: TextArea? = null

    @FXML
    private var listMemory: ListView<String>? = null

    private var accamulator = Accumulator()
    private val memory = Memory()

    @FXML
    private fun clickStart() {
        textConsole!!.text = ""
        accamulator.clear()
        memory.clear()

        val text = textCode!!.text
        val commands = text.split("\n") as ArrayList<String>
        commands.removeIf {it == ""}
        commands.add("HLT")

        commands.filter { it.contains("DATA") }.forEach {
            val buf = it.split(" ") as ArrayList<String>
            val key = Integer.parseInt(buf[1], 16)
            val value = Integer.parseInt(buf[2], 16)
            memory.add(key, value)
        }

        commands.removeIf {it.contains("DATA")}

        var i = 0
        while (commands[i] != "HLT") {
            commands[i] = commands[i].substringBefore("//")

            while (commands[i].contains("  ")) {
                commands[i] = commands[i].replace("  ", " ")
            }

            val words = commands[i].split(" ") as ArrayList<String>

            when (words[0]) {
                "OUT" -> textConsole!!.text += "${Integer.toHexString(accamulator.value)}\n"
                "IN" -> accamulator.value = responseIntHex()
                "LDA" -> accamulator.value = getCell(words[1], memory, accamulator)
                "STA" -> {
                    var buf = words[1]
                    var index: Int
                    when {
                        words[1].contains("@") -> {
                            buf = buf.replace("@", "")
                            index = Integer.parseInt(buf, 16) + accamulator.x
                        }

                        words[1].contains("#") -> {
                            buf = buf.replace("#", "")
                            index = Integer.parseInt(buf, 16)
                        }

                        words[1].contains("*") -> {
                            buf = buf.replace("*", "")
                            index = Integer.parseInt(buf, 16)
                            index = memory[index]
                        }

                        else -> {
                            index = Integer.parseInt(buf, 16)
                        }
                    }

                    memory[index] = accamulator.value
                }
                "ADD"-> accamulator.value += getCell(words[1], memory, accamulator)
                "SUB"-> accamulator.value -= getCell(words[1], memory, accamulator)
                "BRA"-> {
                    i = Integer.parseInt(words[1], 16)
                    i--
                }

                "CPAX" -> accamulator.x = accamulator.value
                "CPAY" -> accamulator.y = accamulator.value

                "CPXA" -> accamulator.value = accamulator.x
                "CPYA" -> accamulator.value = accamulator.y

                "BRGT" -> {
                    if (accamulator.value > 0) {
                        i = Integer.parseInt(words[1], 16)
                        i--
                    }
                }

                "BRGE" -> {
                    if (accamulator.value >= 0) {
                        i = Integer.parseInt(words[1], 16)
                        i--
                    }
                }

                "BRLT" -> {
                    if (accamulator.value < 0) {
                        i = Integer.parseInt(words[1], 16)
                        i--
                    }
                }

                "BRLE" -> {
                    if (accamulator.value <= 0) {
                        i = java.lang.Integer.parseInt(words[1], 16)
                        i--
                    }
                }

                "BRNE" -> {
                    if (accamulator.value != 0) {
                        i = Integer.parseInt(words[1], 16)
                        i--
                    }
                }

                "LDX"-> accamulator.x = getCell(words[1], memory, accamulator)
                "LDY"-> accamulator.y = getCell(words[1], memory, accamulator)
            }
            i++
        }

        listMemory!!.items.clear()

        for (i in memory.data) {
            listMemory!!.items.add("${Integer.toHexString(i.key)}\t--->\t${Integer.toHexString(i.value)}")
        }

        textAccumulator!!.text = accamulator.toString()

    }
}