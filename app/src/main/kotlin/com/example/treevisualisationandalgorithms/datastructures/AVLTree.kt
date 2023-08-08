package com.example.treevisualisationandalgorithms.datastructures

import com.example.treevisualisationandalgorithms.nodeControl.StepControls
import com.example.treevisualisationandalgorithms.renderTree.TreeLayout

// The following link has been used to help create the AVLTree class https://algorithmtutor.com/Data-Structures/Tree/AVL-Trees/

class AVLTree : TreeLayout() {
    
    private var foundNode: Node? = null
    override val n: Int = 2


    override fun loadTree(key: Int) {
        when {
            exists(key) -> return
            else -> addAction(key)
        }

        val newNode = Node(key, 2)
        newNode.nodeHeight = 0
        root = loadTreeHelper(root, newNode)
        drawNodesWithEdges()
    }

    private fun loadTreeHelper(node: Node?, newNode: Node): Node {
        if (node == null) return newNode
        if (newNode.key < node.key) {
            node.children[0] =
                loadTreeHelper(node.children[0], newNode)
        } else {
            node.children[1] =
                loadTreeHelper(node.children[1], newNode)
        }
        newHeight(node)
        return balance(node)
    }


    override fun insertNode(key: Int) {
        when {
            exists(key) -> return
            else -> addAction(key)
        }
        root = insertNodeHelper(root, null, key)
    }

    private fun insertNodeHelper(node: Node?, parent: Node?, key: Int): Node {
        if (node == null) {
            val newNode = Node(key, 2)
            newNode.nodeHeight = 0
            setTreeCoordinates()
            plotNodes()
            return newNode
        }

        addChangeCurrentNodeColour(node, StepControls.duration)
        if (key < node.key) {
            node.children[0] =
                insertNodeHelper(node.children[0], node, key)
        } else {
            node.children[1] =
                insertNodeHelper(node.children[1], node, key)
        }
        setTreeCoordinates()
        plotNodes()
        newHeight(node)
        return balance(node, parent, childIndex(node, parent))
    }

    private fun childIndex(node: Node?, parent: Node?): Int {
        if (parent == null || node == null) {
            return -1
        }
        return if (node === parent.children[0]) {
            0
        } else {
            1
        }
    }


    override fun exploredNodesInsert(key: Int): ArrayList<Int> {
        val treeSelectedNodes = ArrayList<Int>()
        when {
            exists(key) -> return treeSelectedNodes
            else -> addAction(key)
        }


        Node(key, 2)
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
        when {
            exists(key) -> {
                root = reloadTreeHelper(root, key)
                minusAction(key)
            }
            else -> return
        }
        drawNodesWithEdges()
    }

    private fun reloadTreeHelper(node: Node?, key: Int): Node? {
        if (node == null) return null

        when {
            key < node.key -> node.children[0] = reloadTreeHelper(node.children[0], key)
            key > node.key -> node.children[1] = reloadTreeHelper(node.children[1], key)
            else -> {
                when {
                    node.children[0] == null -> return node.children[1]
                    node.children[1] == null -> return node.children[0]
                    else -> {
                        if (node.children[0]!!.nodeHeight > node.children[1]!!.nodeHeight) {
                            node.key = largestKey(node.children[0]!!)
                            node.children[0] = reloadTreeHelper(node.children[0], node.key)
                        } else {
                            node.key = smallestKey(node.children[1]!!)
                            node.children[1] = reloadTreeHelper(node.children[1], node.key)
                        }
                    }
                }
            }
        }

        newHeight(node)
        return balance(node)
    }


    override fun deleteNode(key: Int) {
        when {
            exists(key) -> {
                addChangeCurrentNodeColour(root, StepControls.duration)
                root = deleteNodeHelper(root, null, 0, key)
                minusAction(key)
            }
            else -> return
        }
    }

    private fun deleteNodeHelper(node: Node?, parent: Node?, child: Int, key: Int): Node? {
        if (node == null) return null

        if (foundNode == null) addChangeCurrentNodeColour(node, StepControls.duration)
        when {
            key < node.key -> {
                node.children[0] = deleteNodeHelper(node.children[0], node, 0, key)
            }
            key > node.key -> {
                node.children[1] = deleteNodeHelper(node.children[1], node, 1, key)
            }
            else -> {

                foundNode = node
                when {
                    node.children[0] == null -> {
                        if (node == root) {
                            root = node.children[1]
                        } else {
                            parent!!.children[child] = node.children[1]
                        }
                        return node.children[1]
                    }
                    node.children[1] == null -> {
                        if (node == root) {
                            root = node.children[0]
                        } else {
                            parent!!.children[child] = node.children[0]
                        }
                        return node.children[0]
                    }
                    else -> {
                        if (node.children[0]!!.nodeHeight > node.children[1]!!.nodeHeight) {
                            val successorValue = largestKey(node.children[0]!!)
                            node.key = successorValue
                            node.children[0] =
                                deleteNodeHelper(node.children[0], node, 0, successorValue)
                        } else {
                            val successorValue = smallestKey(node.children[1]!!)
                            node.key = successorValue
                            node.children[1] =
                                deleteNodeHelper(node.children[1], node, 1, successorValue)
                        }
                    }
                }
            }
        }

        newHeight(node)
        return balance(node, parent, child)
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


    private fun newHeight(node: Node) {
        val leftNodeHeight = node.children[0]?.nodeHeight ?: -1
        val rightNodeHeight = node.children[1]?.nodeHeight ?: -1

        node.nodeHeight = 1 + maxOf(leftNodeHeight, rightNodeHeight)

        node.balanceFactor = rightNodeHeight - leftNodeHeight
    }


    private fun balance(node: Node): Node {
        when (node.balanceFactor) {
            -2 -> {
                return if ((node.children[0]?.balanceFactor ?: 0) <= 0) {
                    rightRotate(node)
                } else {
                    node.children[0] = leftRotate(node.children[0]!!)
                    rightRotate(node)
                }
            }
            2 -> {
                return if ((node.children[1]?.balanceFactor ?: 0) >= 0) {
                    leftRotate(node)
                } else {
                    node.children[1] = rightRotate(node.children[1]!!)
                    leftRotate(node)
                }
            }
            else -> return node
        }
    }


    private fun balance(node: Node, parentNode: Node?, child: Int): Node {
        var rotatedNode = node

        when (node.balanceFactor) {
            -2 -> {
                if ((node.children[0]?.balanceFactor ?: 0) <= 0) {

                    rotatedNode = rightRotate(node)
                } else {

                    node.children[0] = leftRotate(node.children[0]!!)
                    rotatedNode = rightRotate(node)
                }
            }
            2 -> {
                if ((node.children[1]?.balanceFactor ?: 0) >= 0) {

                    rotatedNode = leftRotate(node)
                } else {

                    node.children[1] = rightRotate(node.children[1]!!)
                    rotatedNode = leftRotate(node)
                }
            }
        }

        if (parentNode == null) {
            root = rotatedNode
        } else {
            parentNode.children[child] = rotatedNode
        }

        setTreeCoordinates()
        recordTreeRotation()

        return rotatedNode
    }

    private fun smallestKey(node: Node): Int {
        var currentNode = node
        while (currentNode.children[0] != null) currentNode = currentNode.children[0]!!
        return currentNode.key
    }


    private fun largestKey(node: Node): Int {
        var currentNode = node
        while (currentNode.children[1] != null) currentNode = currentNode.children[1]!!
        return currentNode.key
    }

    private fun leftRotate(node: Node) = node.children[1]?.let { rightNode ->
        node.children[1] = rightNode.children[0]
        rightNode.children[0] = node
        newHeight(node)
        newHeight(rightNode)
        rightNode
    } ?: node

    private fun rightRotate(node: Node) = node.children[0]?.let { leftNode ->
        node.children[0] = leftNode.children[1]
        leftNode.children[1] = node
        newHeight(node)
        newHeight(leftNode)
        leftNode
    } ?: node


}