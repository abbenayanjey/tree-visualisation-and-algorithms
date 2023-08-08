package com.example.treevisualisationandalgorithms.datastructures

import com.example.treevisualisationandalgorithms.nodeControl.StepControls
import com.example.treevisualisationandalgorithms.renderTree.TreeLayout


class BinarySearchTree : TreeLayout() {

    override val n: Int = 2

    override fun loadTree(key: Int) {
        when {
            exists(key) -> return
            else -> addAction(key)
        }
        val newNode = Node(key, 2)
        if (root == null) {
            root = newNode
        } else {
            var current = root
            var parent: Node?
            while (true) {
                parent = current
                if (key < current!!.key) {
                    current = current.children[0]
                    if (current == null) {
                        parent!!.children[0] = newNode
                        break
                    }
                } else {
                    current = current.children[1]
                    if (current == null) {
                        parent!!.children[1] = newNode
                        break
                    }
                }
            }
        }
        drawNodesWithEdges()
    }


    override fun insertNode(key: Int) {

        when {
            exists(key) -> return
            else -> addAction(key)
        }
        plotNodes()
        val newNode = Node(key, 2)
        if (root == null) {
            root = newNode
            setTreeCoordinates()
            return
        }
        var current = root
        addChangeCurrentNodeColour(current, StepControls.duration)
        var parent: Node?
        while (true) {
            parent = current
            if (key < current!!.key) {
                current = current.children[0]
                if (current == null) {
                    parent!!.children[0] = newNode
                    setTreeCoordinates()
                    return
                } else {
                    addChangeCurrentNodeColour(current, StepControls.duration)
                }
            } else {
                current = current.children[1]
                if (current == null) {
                    parent!!.children[1] = newNode
                    setTreeCoordinates()
                    return
                } else {
                    addChangeCurrentNodeColour(current, StepControls.duration)
                }
            }
        }

    }


    override fun exploredNodesInsert(key: Int): ArrayList<Int> {
        val treeSelectedNodes = ArrayList<Int>()
        when {
            exists(key) -> return treeSelectedNodes
            else -> addAction(key)
        }

        val newNode = Node(key, 2)
        if (root == null) {
            treeSelectedNodes.add(key)
            return treeSelectedNodes
        }

        var current = root
        var parent: Node?
        while (true) {
            parent = current
            treeSelectedNodes.add(current!!.key)

            if (key < current.key) {
                current = current.children[0]
                if (current == null) {
                    treeSelectedNodes.removeAt(treeSelectedNodes.lastIndex)
                    treeSelectedNodes.add(parent!!.key)
                    return treeSelectedNodes
                }
            } else {
                current = current.children[1]
                if (current == null) {
                    treeSelectedNodes.removeAt(treeSelectedNodes.lastIndex)
                    treeSelectedNodes.add(parent!!.key)
                    return treeSelectedNodes
                }
            }
        }
    }


    override fun reloadTree(key: Int) {
        minusAction(key)
        if (exists(key)) {
            var parent = root
            var current: Node? = root ?: return
            var isLeftChild = false


            while (current!!.key != key) {
                parent = current
                isLeftChild = current.key > key
                current = current.children[if (isLeftChild) 0 else 1]
                if (current == null) {
                    drawNodesWithEdges()
                    return
                }
            }


            when {
                current.children[0] == null && current.children[1] == null -> {
                    if (current == root) root = null
                    else parent!!.children[if (isLeftChild) 0 else 1] = null
                }
                current.children[1] == null -> {
                    if (current == root) root = current.children[0]
                    else parent!!.children[if (isLeftChild) 0 else 1] = current.children[0]
                }
                current.children[0] == null -> {
                    if (current == root) root = current.children[1]
                    else parent!!.children[if (isLeftChild) 0 else 1] = current.children[1]
                }
                else -> {
                    val successor = nodeSuccessor(current)
                    if (current == root) root = successor
                    else parent!!.children[if (isLeftChild) 0 else 1] = successor
                    successor!!.children[0] = current.children[0]
                }
            }

            drawNodesWithEdges()

        }

    }


    override fun deleteNode(key: Int) {
        minusAction(key)
        if (exists(key)) {
            var parent = root
            var current: Node? = root ?: return
            var isLeftChild = false


            addChangeCurrentNodeColour(current, StepControls.duration)
            while (current!!.key != key) {
                parent = current
                isLeftChild = current.key > key
                current = current.children[if (isLeftChild) 0 else 1]
                addChangeCurrentNodeColour(current, StepControls.duration)
                if (current == null) {
                    addChangeCurrentNodeColour(null, StepControls.duration)
                    drawNodesWithEdges()
                    return
                }
            }

            when {
                current.children[0] == null && current.children[1] == null -> {
                    if (current == root) root = null
                    else parent!!.children[if (isLeftChild) 0 else 1] = null
                }
                current.children[1] == null -> {
                    if (current == root) root = current.children[0]
                    else parent!!.children[if (isLeftChild) 0 else 1] = current.children[0]
                }
                current.children[0] == null -> {
                    if (current == root) root = current.children[1]
                    else parent!!.children[if (isLeftChild) 0 else 1] = current.children[1]
                }
                else -> {
                    val successor = nodeSuccessor(current)
                    if (current == root) root = successor
                    else parent!!.children[if (isLeftChild) 0 else 1] = successor
                    successor!!.children[0] = current.children[0]
                }
            }

            drawNodesWithEdges()
        }

    }


    override fun exploredNodesDelete(key: Int): ArrayList<Int> {
        var parent = root
        var current: Node? = root ?: return ArrayList<Int>()

        var isLeftChild = false

        val exploredNodes = ArrayList<Int>()
        exploredNodes.add(current!!.key)

        while (current!!.key != key) {
            parent = current
            if (current.key > key) {
                isLeftChild = true
                current = current.children[0]
            } else {
                isLeftChild = false
                current = current.children[1]
            }
            if (current == null) {
                drawNodesWithEdges()
                return exploredNodes
            }
            exploredNodes.add(current.key)
        }


        return exploredNodes
    }


    private fun nodeSuccessor(currentNode: Node?): Node? {
        var successorNode: Node? = currentNode?.children?.get(1)
        var parentNode: Node? = null

        while (successorNode?.children?.get(0) != null) {
            parentNode = successorNode
            successorNode = successorNode.children[0]
        }

        if (successorNode != currentNode?.children?.get(1)) {
            parentNode?.children?.set(0, successorNode?.children?.get(1))
            successorNode?.children?.set(1, currentNode?.children?.get(1))
        }

        return successorNode
    }


}