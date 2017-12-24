package com.kudryavtsev.anton

import com.kudryavtsev.anton.design.LinksFXML
import com.kudryavtsev.anton.design.component.Frame
import javafx.application.Application
import javafx.application.Application.launch
import javafx.stage.Stage

class Main: Application() {
    override fun start(primaryStage: Stage?) {
        val frame = Frame(LinksFXML.WINDOW.path)
        frame.show()
    }
}

fun main(args: Array<String>) {
    launch(Main::class.java)
}