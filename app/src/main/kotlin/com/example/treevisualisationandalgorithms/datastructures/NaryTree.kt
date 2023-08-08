package com.example.treevisualisationandalgorithms.datastructures

import com.example.treevisualisationandalgorithms.nodeControl.StepControls
import com.example.treevisualisationandalgorithms.renderTree.TreeLayout
import java.util.*

class NaryTree : TreeLayout() {


    override val n: Int
        get() = Companion.n


    override fun loadTree(key: Int) {

        addAction(key)
        val newNode = Node(key, Companion.n)
        if (root == null) {
            root = newNode
            drawNodesWithEdges()
            return
        }

        val queue = LinkedList<Node>()
        queue.add(root!!)

        while (queue.isNotEmpty()) {
            val node = queue.poll()

            for (i in 0 until Companion.n) {
                if (node != null) {
                    if (node.children[i] == null) {
                        node.children[i] = newNode
                        drawNodesWithEdges()
                        return
                    } else {
                        node.children[i]?.let { queue.add(it) }
                    }
                }
            }
        }
    }


    override fun insertNode(key: Int) {

        addAction(key)
        val newNode = Node(key, Companion.n)
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

            for (i in 0 until Companion.n) {
                if (node != null) {
                    if (node.children[i] == null) {
                        node.children[i] = newNode
                        drawNodesWithEdges()
                        return
                    } else {
                        node.children[i]?.let { queue.add(it) }
                    }
                }
            }
        }
    }


    override fun exploredNodesInsert(key: Int): ArrayList<Int> {

        val treeSelectedNodes = ArrayList<Int>()
        val newNode = Node(key, Companion.n)
        if (root == null) {
            return treeSelectedNodes
        }

        val queue = LinkedList<Node>()
        queue.add(root!!)

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node != null) {
                treeSelectedNodes.add(node.key)
            }
            for (i in 0 until Companion.n) {
                if (node != null) {
                    if (node.children[i] == null) {
                        treeSelectedNodes.add(newNode.key)
                        treeSelectedNodes.removeLast()
                        return treeSelectedNodes
                    } else {
                        node.children[i]?.let { queue.add(it) }
                    }
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
            queue.add(root!!)

            val numChildren = Companion.n

            while (queue.isNotEmpty()) {
                val node = queue.poll()

                for (i in 0 until numChildren) {
                    if (node != null) {
                        if (node.children[i]?.key == key) {
                            node.children[i] = null
                            drawNodesWithEdges()
                            return
                        } else {
                            node.children[i]?.let { queue.add(it) }
                        }
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

            if (root?.key == key) {
                root = null
                drawNodesWithEdges()
                return
            }

            val queue = LinkedList<Node>()
            queue.add(root!!)

            val numChildren = Companion.n

            while (queue.isNotEmpty()) {
                val node = queue.poll()
                addChangeCurrentNodeColour(node, StepControls.duration)

                for (i in 0 until numChildren) {
                    if (node != null) {
                        if (node.children[i]?.key == key) {
                            node.children[i] = null
                            drawNodesWithEdges()
                            return
                        } else {
                            node.children[i]?.let { queue.add(it) }
                        }
                    }
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
            return treeSelectedNodes
        }

        val queue = LinkedList<Node>()
        queue.add(root!!)


        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node != null) {
                treeSelectedNodes.add(node.key)
            }
            for (i in 0 until Companion.n) {
                if (node != null) {
                    if (node.children[i]?.key == key) {
                        treeSelectedNodes.add(key)
                        treeSelectedNodes.removeLast()
                        return treeSelectedNodes

                    } else {
                        node.children[i]?.let { queue.add(it) }
                    }
                }
            }
        }
        return treeSelectedNodes
    }


    companion object {

        var n = 3

        fun setNumChildrenProperty(value: Int) {
            n = value
        }
    }
}