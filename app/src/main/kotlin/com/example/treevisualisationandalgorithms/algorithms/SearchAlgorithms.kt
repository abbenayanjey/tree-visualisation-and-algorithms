package com.example.treevisualisationandalgorithms.algorithms

import com.example.treevisualisationandalgorithms.datastructures.Node
import com.example.treevisualisationandalgorithms.nodeControl.StepControls
import com.example.treevisualisationandalgorithms.renderTree.RenderNodes
import java.util.*

abstract class SearchAlgorithms : RenderNodes() {

    var root: Node? = null

    abstract val n: Int

    private fun binarySearch(key: Int, currentNode: Node?) {
        if (currentNode == null) { addChangeCurrentNodeColour(null, StepControls.duration)
            return
        }

        addChangeCurrentNodeColour(currentNode, StepControls.duration)

        when {

            key == currentNode.key -> return
            key < currentNode.key -> binarySearch(key, currentNode.children[0])
            else -> binarySearch(key, currentNode.children[1])
        }
    }


    private fun bfs(key: Int, root: Node?) {
        if (root == null) { addChangeCurrentNodeColour(null, StepControls.duration)
            return
        }

        val queue = LinkedList<Node>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val currentNode = queue.poll()

            addChangeCurrentNodeColour(currentNode, StepControls.duration)

            if (currentNode != null) {
                if (currentNode.key == key) {
                    return
                }
            }

            currentNode?.children?.forEach { child ->
                child?.let { queue.add(it) }
            }
        }

        addChangeCurrentNodeColour(null, StepControls.duration)
    }

    fun performBinarySearch(key: Int) {
        start()
        addChangeCurrentNodeColour(
            root!!,
            StepControls.duration
        )
        binarySearch(key, root)
        end()
        updateVisualizer()
    }

    fun performBfs(key: Int) {
        start()
        addChangeCurrentNodeColour(
            root!!,
            StepControls.duration
        )
        bfs(key, root)
        end()
        updateVisualizer()
    }


    fun exploredNodesBinarySearch(key: Int, currentNode: Node?): ArrayList<Int> {
        val exploredNodes = ArrayList<Int>()

        if (currentNode == null) {
            return exploredNodes
        }

        exploredNodes.add(currentNode.key)

        when {
            key == currentNode.key -> return exploredNodes
            key < currentNode.key -> {
                currentNode.children[0]?.let {
                    exploredNodes.addAll(exploredNodesBinarySearch(key, it))
                }
            }
            else -> {
                currentNode.children[1]?.let {
                    exploredNodes.addAll(exploredNodesBinarySearch(key, it))
                }
            }
        }

        return exploredNodes
    }


    fun exploredNodesBfs(key: Int, rootNode: Node?): ArrayList<Int> {
        val exploredNodes = ArrayList<Int>()

        if (rootNode == null) {
            return exploredNodes
        }

        val queue = LinkedList<Node>()
        queue.add(rootNode)

        while (queue.isNotEmpty()) {
            val currentNode = queue.poll()

            exploredNodes.add(currentNode.key)

            if (currentNode.key == key) {
                return exploredNodes
            }

            currentNode.children.forEach { child ->
                child?.let { queue.add(it) }
            }
        }

        return exploredNodes
    }

}