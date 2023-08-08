package com.example.treevisualisationandalgorithms.renderOperations.operations.insert

import com.example.treevisualisationandalgorithms.renderOperations.operations.Operations

class InsertElements(private val operations: Operations, private var elements: ArrayList<Int>) :
    Runnable {
    override fun run() {
        operations.start()
        elements.forEach { operations.insertNode(it) }
        operations.execute()
        operations.end()
        operations.updateVisualizer()
    }
}