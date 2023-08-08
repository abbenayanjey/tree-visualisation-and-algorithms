package com.example.treevisualisationandalgorithms.renderOperations.operations.insert

import com.example.treevisualisationandalgorithms.renderOperations.operations.Operations

class InsertElement(private val operations: Operations, private val element: Int) : Runnable {

    override fun run() {
        operations.start()
        operations.insertNode(element)
        operations.execute()
        operations.end()
        operations.updateVisualizer()

    }
}