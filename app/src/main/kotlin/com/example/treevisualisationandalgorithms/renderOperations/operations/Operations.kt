package com.example.treevisualisationandalgorithms.renderOperations.operations

import com.example.treevisualisationandalgorithms.renderOperations.VisualiseActionController
import com.example.treevisualisationandalgorithms.renderOperations.operations.delete.DeleteElement
import com.example.treevisualisationandalgorithms.renderOperations.operations.insert.InsertElement
import com.example.treevisualisationandalgorithms.renderOperations.operations.insert.InsertElements
import com.example.treevisualisationandalgorithms.screens.DIY
import com.example.treevisualisationandalgorithms.screens.Visualiser

abstract class Operations : VisualiseActionController() {

    abstract val treeValues: ArrayList<Int>

    abstract fun loadTree(key: Int)

    abstract fun insertNode(key: Int)

    abstract fun exploredNodesInsert(key: Int): ArrayList<Int>

    abstract fun reloadTree(key: Int)

    abstract fun deleteNode(key: Int)

    abstract fun exploredNodesDelete(key: Int): ArrayList<Int>


    fun insertAction(key: Int) {
        val task = InsertElement(this, key)
        Thread(task).start()
    }


    fun insertAction(keys: ArrayList<Int>) {
        val task = InsertElements(this, keys)
        Thread(task).start()
    }


    fun deleteAction(key: Int) {
        val task = DeleteElement(this, key)
        Thread(task).start()
    }


    open fun exists(element: Int): Boolean {
        return treeValues.any { it == element }
    }

    fun updateVisualizer() {
        val type = Visualiser.tree ?: DIY.tree
        type?.let {
            it.resetCurrentNodePath()
            it.draw()
        }
    }


}