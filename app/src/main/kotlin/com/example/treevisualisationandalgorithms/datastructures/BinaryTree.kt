package com.example.treevisualisationandalgorithms.datastructures

import com.example.treevisualisationandalgorithms.nodeControl.StepControls
import com.example.treevisualisationandalgorithms.renderTree.TreeLayout
import java.util.*

class BinaryTree : TreeLayout() {

    override val n: Int = 2

    override fun loadTree(key: Int) {
        addAction(key)
        val newNode = Node(key, 2)
        if (root == null) {
            root = newNode
            drawNodesWithEdges()
            return
        }
        val queue = LinkedList<Node>()
        queue.add(root!!)
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node != null) {
                if (node.children[0] == null) {
                    node.children[0] = newNode
                    break
                } else if (node.children[1] == null) {
                    node.children[1] = newNode
                    break
                } else {
                    node.children[0]?.let { queue.add(it) }
                    node.children[1]?.let { queue.add(it) }
                }
            }
        }
        drawNodesWithEdges()
    }

    override fun insertNode(key: Int) {

        addAction(key)
        val newNode = Node(key, 2)

        if (root == null) {
            root = newNode
            drawNodesWithEdges()
            return
        }

        val queue = LinkedList<Node>()
        queue.add(root!!)

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            addChangeCurrentNodeColour(node, StepControls.duration)
            if (node != null) {
                if (node.children[0] == null) {
                    node.children[0] = newNode
                    drawNodesWithEdges()
                    return
                } else if (node.children[1] == null) {
                    node.children[1] = newNode
                    drawNodesWithEdges()
                    return
                } else {
                    node.children[0]?.let { queue.add(it) }
                    node.children[1]?.let { queue.add(it) }
                }
            }
        }
    }


    override fun exploredNodesInsert(key: Int): ArrayList<Int> {
        val treeSelectedNodes = ArrayList<Int>()
        val newNode = Node(key, 2)
        if (root == null) {

            return treeSelectedNodes
        }

        val queue = LinkedList<Node>()
        queue.add(root!!)

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            treeSelectedNodes.add(node.key)
            if (node != null) {
                if (node.children[0] == null) {

                    treeSelectedNodes.add(newNode.key)
                    treeSelectedNodes.removeLast()
                    return treeSelectedNodes
                } else if (node.children[1] == null) {
                    treeSelectedNodes.add(newNode.key)
                    treeSelectedNodes.removeLast()
                    return treeSelectedNodes
                } else {
                    node.children[0]?.let { queue.add(it) }
                    node.children[1]?.let { queue.add(it) }
                }
            }
        }

        return treeSelectedNodes
    }


    override fun reloadTree(key: Int) {
        minusAction(key)
        if (exists(key)) {

            if (root == null) {
                return
            }

            if (root?.key == key) {
                root = null
                drawNodesWithEdges()
                return
            }
            val queue = LinkedList<Node>()
            queue.add(root ?: return)

            while (queue.isNotEmpty()) {
                val node = queue.poll()

                if (node != null) {
                    if (node.children[0]?.key == key) {
                        node.children[0] = null
                        drawNodesWithEdges()
                        return
                    } else if (node.children[1]?.key == key) {
                        node.children[1] = null
                        drawNodesWithEdges()
                        return
                    } else {
                        node.children[0]?.let { queue.add(it) }
                        node.children[1]?.let { queue.add(it) }
                    }
                }
            }
        }

    }


    override fun deleteNode(key: Int) {
        minusAction(key)
        if (exists(key)) {

            if (root == null) {
                return
            }
            if (root!!.key == key) {
                root = null
                drawNodesWithEdges()
                return
            }
            val queue = LinkedList<Node>()
            queue.add(root!!)
            while (queue.isNotEmpty()) {
                val node = queue.poll()
                addChangeCurrentNodeColour(node, StepControls.duration)
                for (i in 0 until n) {
                    val child = node.children[i] ?: continue
                    if (child.key == key) {
                        node.children[i] = null
                        drawNodesWithEdges()
                        return
                    }
                    queue.add(child)
                }
            }
        }

    }


    override fun exploredNodesDelete(key: Int): ArrayList<Int> {
        val treeSelectedNodes = ArrayList<Int>()
        if (root == null) {
            return treeSelectedNodes
        }

        if (root?.key == key) {
            treeSelectedNodes.add(key)
            return treeSelectedNodes
        }

        val queue = LinkedList<Node>()
        queue.add(root!!)

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            treeSelectedNodes.add(node.key)
            if (node.children[0]?.key == key) {

                treeSelectedNodes.add(key)
                treeSelectedNodes.removeLast()
                return treeSelectedNodes
            } else if (node.children[1]?.key == key) {

                treeSelectedNodes.add(key)
                treeSelectedNodes.removeLast()
                return treeSelectedNodes
            } else {
                node.children[0]?.let { queue.add(it) }
                node.children[1]?.let { queue.add(it) }
            }
        }

        return treeSelectedNodes
    }

}