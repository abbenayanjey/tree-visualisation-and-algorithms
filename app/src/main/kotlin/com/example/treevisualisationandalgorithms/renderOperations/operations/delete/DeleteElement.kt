package com.example.treevisualisationandalgorithms.renderOperations.operations.delete

import com.example.treevisualisationandalgorithms.renderOperations.operations.Operations

class DeleteElement(private val operations: Operations, private var element: Int) : Runnable {
    override fun run() {
        operations.start()
        operations.deleteNode(element)
        operations.execute()
        operations.end()
        operations.updateVisualizer()

    }
}