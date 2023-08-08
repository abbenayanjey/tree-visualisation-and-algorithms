package com.example.treevisualisationandalgorithms.renderTree

import android.graphics.*
import com.example.treevisualisationandalgorithms.MainActivity
import com.example.treevisualisationandalgorithms.datastructures.Node
import com.example.treevisualisationandalgorithms.nodeControl.Step
import com.example.treevisualisationandalgorithms.nodeControl.StepControls
import com.example.treevisualisationandalgorithms.renderOperations.ActionRecord

abstract class RenderNodes : ActionRecord() {

    private var currentNode: Node? = null
    private var currentNodePath = ArrayList<Node>()

    protected fun visualiseNode(node: Node, visual: Canvas) {
        val nodeColour = Paint()
        val nodeValueStyle = Paint()
        val blue = Color.parseColor("#256EFF")
        val red = Color.parseColor("#FF0000")

//        val nodeFont = ResourcesCompat.getFont(context, R.font.google_sans_bold)
        val xCoordinate = node.startingCoordinates[0].toFloat()
        val yCoordinate = node.startingCoordinates[1].toFloat()
        val nodeValue = node.key.toString()

        when (currentNodePath.contains(node)) {
            true -> nodeColour.color = red
            false -> nodeColour.color = blue
        }
        nodeValueStyle.color = Color.WHITE
        nodeValueStyle.textAlign = Paint.Align.CENTER
        nodeValueStyle.textSize = 40f
        nodeValueStyle.typeface = Typeface.create(Typeface.MONOSPACE, Typeface.BOLD)
//        nodeValueStyle.typeface = nodeFont

        visual.drawOval(
            xCoordinate - 40,
            yCoordinate - 40,
            xCoordinate + 40,
            yCoordinate + 40,
            nodeColour
        )

        visual.drawText(
            nodeValue,
            xCoordinate,
            yCoordinate + 15f,
            nodeValueStyle
        )
    }


    fun changeNodeColour(node: Node, visual: Canvas) {
        val newColour = Paint()
        val orange = Color.parseColor("#FF9300")
        val xCoordinate = node.startingCoordinates[0].toFloat()
        val yCoordinate = node.startingCoordinates[1].toFloat()
        val nodeValue = node.key.toString()

        val nodeValueStyle = Paint()
        newColour.color = orange
        nodeValueStyle.color = Color.WHITE
        nodeValueStyle.textAlign = Paint.Align.CENTER
        nodeValueStyle.textSize = 40f
        nodeValueStyle.typeface = Typeface.create(Typeface.MONOSPACE, Typeface.BOLD)
//         nodeValueStyle.typeface = nodeFont

        visual.drawCircle(
            xCoordinate,
            yCoordinate,
            40f, newColour
        )
        visual.drawText(
            nodeValue,
            xCoordinate,
            yCoordinate + 15f,
            nodeValueStyle
        )
    }


    private fun setCurrentNode(node: Node) {
        currentNode = node
    }


    private fun changeCurrentNode() {
        currentNode = null
    }

    fun getCurrentNodePath(): ArrayList<Node> {
        return currentNodePath
    }

    fun resetCurrentNodePath(): ArrayList<Node> {
        currentNodePath.clear()
        return currentNodePath
    }

    protected fun addCurrentNode(node: Node) {

        if (currentNode != null) changeCurrentNode()

        setCurrentNode(node)
        currentNodePath.add(node)
    }


    private fun changeCurrentNodeColour(node: Node, visual: Canvas) {
        addCurrentNode(node)
        draw(visual)
    }


    protected fun addChangeCurrentNodeColour(node: Node?, time: Int) {
        node?.let { CurrentNode(it, time) }?.let { stepHistory.add(it) }
    }


    private fun rotateTree(step: Int, visual: Canvas?) {
        val nodes = treeNodes
        val frame: Float = (StepControls.frames - step).toFloat()
        var i = 0
        while (i < nodes.size) {
            val node = nodes[i]
            node.startingCoordinates[0] += ((node.finalCoordinates[0] - node.startingCoordinates[0]) / frame).toInt()
            node.startingCoordinates[1] += ((node.finalCoordinates[1] - node.startingCoordinates[1]) / frame).toInt()
            i++
        }

        draw(visual)
    }


    protected fun recordTreeRotation() {
        stepHistory.add(RotateTree())
    }


    protected fun plotNodes() {
        val nodes = treeNodes

        var i = 0
        while (i < nodes.size) {
            val node = nodes[i]
            node.startingCoordinates[0] = node.finalCoordinates[0]
            node.startingCoordinates[1] = node.finalCoordinates[1]
            i++
        }
    }


    abstract val treeNodes: ArrayList<Node>

    fun getNode(key: Int): Node? {
        var i = 0
        while (i < treeNodes.size) {
            val node = treeNodes[i]
            if (node.key == key) return node
            i++
        }
        return null
    }


    override val treeValues: ArrayList<Int>
        get() {
            val keys = ArrayList<Int>()
            var i = 0
            while (i < treeNodes.size) {
                val node = treeNodes[i]
                keys.add(node.key)
                i++
            }
            return keys
        }


    fun getUserSelectedNode(xPos: Int, yPos: Int): Int {

        val nodes = treeNodes
        var i = 0
        while (i < nodes.size) {
            val node = nodes[i]
            if (validTouchPosition(xPos, yPos, node)) {
                return node.key
            }
            i++
        }

        return -1
    }

    fun getColourOfSelectedNode(xPos: Int, yPos: Int): Node? {

        val nodes = treeNodes
        var i = 0
        while (i < nodes.size) {
            val node = nodes[i]
            if (validTouchPosition(xPos, yPos, node)) {
                return node
            }
            i++
        }
        return null
    }

    private inner class CurrentNode(
        node: Node,
        var time: Int
    ) : Step() {

        var visual: Canvas
        var surface: Bitmap = MainActivity.getCanvas().let {
            MainActivity.getCanvas().height.let { it1 -> Bitmap.createBitmap(it.width, it1, Bitmap.Config.ARGB_8888)
            }
        }

        init {
            visual = Canvas(surface)
            changeCurrentNodeColour(node, visual)
        }


        override fun perform() {

            surface.let {
                MainActivity.getCanvas().drawBitmap(it, MainActivity.getCanvas().clipBounds, visual.clipBounds, Paint())
            }

            try {
                Thread.sleep(time.toLong())
            } catch (e: InterruptedException) {
                return
            }
        }

        override fun performStepBackwards() {
            perform()
        }


    }

    private inner class RotateTree(
    ) : Step() {

        var visual = arrayOfNulls<Canvas>(StepControls.frames)
        var surface = arrayOfNulls<Bitmap>(StepControls.frames)

        init {

            var i = 0
            while (i < StepControls.frames) {
                surface[i] = MainActivity.getCanvas().let {
                    Bitmap.createBitmap(it.width, MainActivity.getCanvas().height, Bitmap.Config.ARGB_8888)
                }
                visual[i] = surface[i]?.let { Canvas(it) }

                rotateTree(i, visual[i])

                i++
            }
        }


        override fun perform() {

            var i = 0
            while (i < StepControls.frames) {
                MainActivity.getCanvas().drawBitmap(surface[i]!!, MainActivity.getCanvas().clipBounds, visual[i]!!.clipBounds, Paint())
                if (MainActivity.screen != null) MainActivity.screen?.display()

                Thread.sleep(((10).toLong()))

                i++
            }
        }

        override fun performStepBackwards() {
            perform()
        }

    }


    private fun validTouchPosition(x: Int, y: Int, node: Node): Boolean {
        val dx = x - node.startingCoordinates[0]
        val dy = y - node.startingCoordinates[1]
        val distance = kotlin.math.sqrt((dx * dx + dy * dy).toDouble())
        return distance < 40f * 1.04
    }


}