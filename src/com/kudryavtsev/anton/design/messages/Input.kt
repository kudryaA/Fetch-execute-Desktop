package com.kudryavtsev.anton.design.messages

import javafx.scene.control.TextInputDialog

fun responseIntHex(): Int {
    val dialog = TextInputDialog("0")
    dialog.title = "Messages"
    dialog.headerText = null
    dialog.contentText = "Input value:"

    val result = dialog.showAndWait()
    if (result.isPresent) {
        try {
            var text = result.get()
            if (text.contentEquals("."))
                text += ".0"
            return Integer.parseInt(text)
        } catch (e: NumberFormatException) {
            e.stackTrace
        }
    }
    return 0
}