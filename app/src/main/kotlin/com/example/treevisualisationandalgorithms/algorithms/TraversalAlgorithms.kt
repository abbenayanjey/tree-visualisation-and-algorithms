package com.example.treevisualisationandalgorithms.algorithms

import com.example.treevisualisationandalgorithms.datastructures.Node
import com.example.treevisualisationandalgorithms.nodeControl.StepControls

abstract class TraversalAlgorithms : SearchAlgorithms() {

    private var traversalNodesDisplayed = ArrayList<Int>()

    private fun addNodeToDisplay(node: Node) {
        traversalNodesDisplayed.add(node.key)
    }

    fun getTraversalNodesDisplayed(): ArrayList<Int> {
        return traversalNodesDisplayed
    }

    private fun preOrder(currentNode: Node?) {

        if (currentNode == null) return

        addChangeCurrentNodeColour(currentNode, StepControls.duration)

        currentNode.children.forEach {
            preOrder(it)
        }
    }


    fun exploredNodesPreOrder(currentNode: Node?) {
        if (currentNode == null) return

        addNodeToDisplay(currentNode)

        currentNode.children.forEach {
            exploredNodesPreOrder(it)
        }
    }


    fun performPreOrder() {
        start()
        preOrder(root)
        end()
        updateVisualizer()
    }


    private fun inOrder(currentNode: Node?) {
        val numChildren = n

        if (currentNode == null) return

        for (i in 0 until numChildren / 2) inOrder(currentNode.children[i])

        addChangeCurrentNodeColour(
            currentNode,
            StepControls.duration
        )

        for (i in numChildren / 2 until numChildren) inOrder(currentNode.children[i])

    }


    fun performInOrder() {
        start()
        inOrder(root)
        end()
        updateVisualizer()
    }

    fun exploredNodesInOrder(currentNode: Node?) {
        val numChildren = n

        if (currentNode == null) return

        for (i in 0 until numChildren / 2) exploredNodesInOrder(currentNode.children[i])

        addNodeToDisplay(currentNode)

        for (i in numChildren / 2 until numChildren) exploredNodesInOrder(currentNode.children[i])
    }


    private fun postOrder(currentNode: Node?) {

        if (currentNode == null) return

        currentNode.children.forEach {
            postOrder(it)
        }

        addChangeCurrentNodeColour(currentNode, StepControls.duration)

    }


    fun performPostOrder() {
        start()
        postOrder(root)
        end()
        updateVisualizer()
    }


    fun exploredNodesPostOrder(currentNode: Node?) {
        if (currentNode == null) return


        currentNode.children.forEach {
            exploredNodesPostOrder(it)
        }

        addNodeToDisplay(currentNode)
    }
}