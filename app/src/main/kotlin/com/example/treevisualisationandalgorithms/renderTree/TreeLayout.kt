package com.example.treevisualisationandalgorithms.renderTree

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.treevisualisationandalgorithms.MainActivity
import com.example.treevisualisationandalgorithms.algorithms.TraversalAlgorithms
import com.example.treevisualisationandalgorithms.datastructures.Node
import org.json.JSONArray
import org.json.JSONObject
import java.util.*


abstract class TreeLayout : TraversalAlgorithms() {

    data class QueueNode(
        val node: Node,
        val depth: Int,
        val x: Float,
        val y: Float,
        val width: Float
    )

    fun setTreeCoordinates() {

        val width = MainActivity.getCanvas().width
        val rad = 40f
        val numChildren = n
        val depth = depth

        root ?: return

        root!!.finalCoordinates[0] = width / 2
        root!!.finalCoordinates[1] = (rad * 2).toInt()


        val newWidth = (width - rad) / numChildren

        val queue: Queue<QueueNode> = LinkedList()
        queue.add(
            QueueNode(
                root!!,
                1,
                root!!.finalCoordinates[0].toFloat(),
                root!!.finalCoordinates[1].toFloat(),
                newWidth
            )
        )

        while (queue.isNotEmpty()) {
            val (currentNode, currentDepth, x, y, currentWidth) = queue.poll()

            if (currentDepth < depth) {
                var nextX = x - (currentWidth * (1.0 + numChildren) / 2.0).toInt()
                val nextY = y + 120f.toInt() * when (currentDepth) {
                    1 -> 0.7f
                    2 -> 1.3f
                    3 -> 1.5f
                    4 -> 1.6f
                    else -> 1.5f
                }

                for (i in 0 until numChildren) {
                    val child = currentNode.children[i]
                    if (child != null) {
                        nextX += currentWidth.toInt()

                        child.finalCoordinates[0] = nextX.toInt()
                        child.finalCoordinates[1] = nextY.toInt()
                        val newWidth = currentWidth / numChildren
                        queue.add(
                            QueueNode(
                                child,
                                currentDepth + 1,
                                nextX,
                                nextY,
                                newWidth
                            )
                        )
                    } else {
                        nextX += currentWidth.toInt()
                    }
                }
            }
        }
    }

    private fun drawEdge(rootNode: Node?, canvas: Canvas?) {
        if (rootNode == null) return

        val queue: Queue<Node> = LinkedList()
        queue.add(rootNode)

        while (queue.isNotEmpty()) {
            val currNode = queue.poll()

            val edge = Paint()
            val edgeColour = Color.parseColor("#256EFF")
            edge.strokeWidth = 10f
            edge.color = edgeColour
            for (i in 0 until n) {
                val child = currNode?.children?.getOrNull(i)
                if (currNode != null) {
                    if (child != null && currNode.key != Int.MIN_VALUE && child.key != Int.MIN_VALUE) {
                        canvas!!.drawLine(
                            currNode.startingCoordinates[0].toFloat(),
                            currNode.startingCoordinates[1].toFloat(),
                            child.startingCoordinates[0].toFloat(),
                            child.startingCoordinates[1].toFloat(),
                            edge
                        )
                        queue.add(child)
                    }
                }
            }


            if (currNode != null) {
                visualiseNode(currNode, canvas!!)
            }
        }
    }


    override fun draw(canvas: Canvas?) {

        canvas!!.drawColor(Color.WHITE)

        drawEdge(root, canvas)

        super.draw(canvas)
    }

    public override fun drawNodesWithEdges() {

        setTreeCoordinates()
        plotNodes()
        draw()
    }

    private fun getTreeNodes(currNode: Node?): ArrayList<Node> {
        val nodes = ArrayList<Node>()

        if (currNode != null) {
            for (child in currNode.children) {
                nodes.addAll(getTreeNodes(child))
            }
            nodes.add(currNode)
        }

        return nodes
    }


    override val treeNodes: ArrayList<Node>
        get() = getTreeNodes(root)


    val treeKeysBFS: ArrayList<Int>?
        get() {
            val keyList = ArrayList<Int>()
            if (root == null) {
                return null
            }
            var currentNode: Node = root as Node
            keyList.add(currentNode.key)
            val queue = LinkedList<Node>()

            while (true) {

                for (i in 0 until n) {
                    if (currentNode.children[i] != null) {
                        queue.addLast(currentNode.children[i])
                    }
                }

                if (!queue.isEmpty()) {
                    currentNode = queue.pop()
                    keyList.add(currentNode.key)
                } else break
            }
            return keyList
        }


    fun serialise(type: String?): JSONObject? {
        val keyList = treeKeysBFS ?: return null

        val tree = JSONObject()

        tree.put("Type", type)
        tree.put("Values", JSONArray(keyList))

        return tree

    }

    private fun getTreeDepth(root: Node?): Int {
        if (root == null) {
            return 0
        }

        var depth = 0
        val queue = LinkedList<Node>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            depth++
            val size = queue.size

            for (i in 0 until size) {
                val node = queue.poll()

                for (j in 0 until n) {
                    val child = node?.children?.getOrNull(j)
                    if (child != null) {
                        queue.add(child)
                    }
                }
            }
        }

        return depth
    }


    private val depth: Int
        get() = getTreeDepth(root)

}