package com.kudryavtsev.anton.design.component

import com.kudryavtsev.anton.Main
import javafx.fxml.*
import javafx.scene.*
import javafx.scene.image.Image
import javafx.stage.*

class Frame(path: String): Stage() {

    private val pathImage = "/com/kudryavtsev/anton/design/image/logo.png"

    init {
        icons.add(Image(pathImage))
        val root = FXMLLoader.load<Parent>(Main::class.java.getResource(path))
        scene = Scene(root)
        title = "Fetch execute"
    }
}