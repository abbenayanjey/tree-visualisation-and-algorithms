package com.example.treevisualisationandalgorithms.screens

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.doOnLayout
import androidx.fragment.app.Fragment
import com.example.treevisualisationandalgorithms.*
import com.example.treevisualisationandalgorithms.datastructures.AVLTree
import com.example.treevisualisationandalgorithms.datastructures.BinarySearchTree
import com.example.treevisualisationandalgorithms.datastructures.BinaryTree
import com.example.treevisualisationandalgorithms.datastructures.NaryTree
import com.example.treevisualisationandalgorithms.nodeControl.StepControls
import com.example.treevisualisationandalgorithms.renderTree.DisplayTree
import com.example.treevisualisationandalgorithms.renderTree.TreeLayout
import com.example.treevisualisationandalgorithms.serialise.LoadTree
import com.example.treevisualisationandalgorithms.serialise.SaveTree.Companion.setTopic
import com.google.android.material.textview.MaterialTextView


class DIY : Fragment {

    private var input: EditText? = null
    private var topic: String? = null
    private var displayTree: DisplayTree? = null
    private var loadTree: ArrayList<Int>? = null
    private var layoutIdDialog: String? = null
    private var userSelectedNodes = ArrayList<Int>()


    override fun onResume() {
        super.onResume()
        displayTree?.updateDIY(this)
        MainActivity.setVisualizerCanvas(displayTree)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View
        val selectedTopic = when (topic) {
            "Binary Tree" -> R.layout.binary_diy_screen
            "Nary Tree" -> R.layout.nary_diy_screen
            "Binary Search Tree" -> R.layout.bst_diy_screen
            "AVL Tree" -> R.layout.avl_diy_screen
            "Linear List to BST" -> R.layout.bst_diy_screen
            else -> R.layout.home_screen
        }
        layoutIdDialog = selectedTopic.toString()
        view = inflater.inflate(selectedTopic, container, false)

        when (selectedTopic) {
            R.layout.binary_diy_screen, R.layout.nary_diy_screen, R.layout.bst_diy_screen, R.layout.avl_diy_screen -> {
                setTopic()
                createModeSwitchButtons(view)
                createDIYFeatures(view)
                createMovementButtons(view)
            }

        }

        return view
    }

    constructor(topic: String) {
        this.topic = topic
        loadTree = null
    }

    constructor(topic: String, treeValues: ArrayList<Int>?) {
        this.topic = topic
        loadTree = treeValues
    }

    private fun createModeSwitchButtons(view: View) {
        val visualiserButton = view.findViewById<AppCompatButton>(R.id.visualiserButton)
        val diyButton = view.findViewById<AppCompatButton>(R.id.diyButton)

        diyButton.setTextColor(Color.WHITE)
        visualiserButton.setTextColor(Color.BLACK)
        visualiserButton.setOnClickListener {
            visualiserButton.setBackgroundResource(R.drawable.round_bt_blue)
            visualiserButton.setTextColor(Color.WHITE)
            diyButton.setBackgroundResource(R.drawable.round_bt)
            diyButton.setTextColor(Color.BLACK)
            MainActivity.openFragment(Visualiser(topic.toString()))
            StepControls.resetAllSteps()
            tree?.resetTree()
            tree = null

        }

        diyButton.setBackgroundResource(R.drawable.round_bt_blue)
        diyButton.setOnClickListener {
            diyButton.setBackgroundResource(R.drawable.round_bt_blue)
            diyButton.setTextColor(Color.WHITE)
            visualiserButton.setBackgroundResource(R.drawable.round_bt)
            visualiserButton.setTextColor(Color.BLACK)
        }
    }


    @SuppressLint("SetTextI18n", "ClickableViewAccessibility")
    private fun createDIYFeatures(view: View) {

        val loadButton = view.findViewById<AppCompatButton>(R.id.loadDiyButton)
        val checkButton = view.findViewById<Button>(R.id.checkButton)
        val insertButton = view.findViewById<AppCompatButton>(R.id.insertButton)
        val deleteButton = view.findViewById<AppCompatButton>(R.id.deleteButton)
        val searchButton = view.findViewById<AppCompatButton>(R.id.searchButton)
        val inorderButton = view.findViewById<AppCompatButton>(R.id.inorderButton)
        val preorderButton = view.findViewById<AppCompatButton>(R.id.preorderButton)
        val postorderButton = view.findViewById<AppCompatButton>(R.id.postorderButton)
        val selectedNodes = view.findViewById<TextView>(R.id.selectedNodes)
        val testNodes = view.findViewById<TextView>(R.id.testNodes)
        val number3 = view.findViewById<AppCompatButton>(R.id.number3)
        val number4 = view.findViewById<AppCompatButton>(R.id.number4)
        val number5 = view.findViewById<AppCompatButton>(R.id.number5)
        input = view.findViewById(R.id.input_nodes)

        loadButton.setOnClickListener {
            val transaction = childFragmentManager.beginTransaction()
            childFragmentManager.findFragmentByTag("DIY")?.let {
                transaction.remove(it)
            }
            transaction.addToBackStack(null)
            val loadTree = LoadTree(topic, this)
            loadTree.setTree(tree)
            setTopic(topic)
            loadTree.show(transaction, "DIY")

        }


        checkButton.setOnClickListener {
            if (userSelectedNodes.isNotEmpty()) {
                tree!!.draw()
                if ((insertButton.currentTextColor == Color.WHITE)
                    && (input?.text?.toString()
                        ?.toInt()
                        ?.let { it1 -> tree?.exists(it1) } == false) && (input?.text?.length != 0 || input?.text
                        .toString()
                        .toInt() < 999)
                ) {

                    val insertAnswer = insertDIY().toString()
                    testNodes.text = "Insert Path is: " + insertAnswer.substring(
                        1,
                        insertAnswer.length - 1
                    )


                    insert()


                    if (insertAnswer == userSelectedNodes.toString()) {
                        testNodes.setTextColor(Color.GREEN)
                    } else {
                        testNodes.setTextColor(Color.RED)
                    }
                }

                if ((deleteButton.currentTextColor == Color.WHITE) && (input?.text?.length != 0 || input?.text
                        .toString()
                        .toInt() > 999)
                ) {

                    val deleteAnswer = deleteDIY().toString()
                    testNodes.text = "Delete Path is: " + deleteAnswer.substring(
                        1,
                        deleteAnswer.length - 1
                    )
                    delete()
                    if (deleteAnswer == userSelectedNodes.toString()) {
                        testNodes.setTextColor(Color.GREEN)
                    } else {
                        testNodes.setTextColor(Color.RED)
                    }
                }

                if ((searchButton.currentTextColor == Color.WHITE) && (input?.text?.length != 0 || input?.text
                        .toString()
                        .toInt() > 999)
                ) {

                    if (topic == "Binary Search Tree" || topic == "AVL Tree") {
                        val searchAnswer = binarySearchDIY().toString()
                        testNodes.text = "Search Path is: " + searchAnswer.substring(
                            1,
                            searchAnswer.length - 1
                        )
                        val searchNum: Int = input!!.text.toString().toInt()
                        tree?.performBinarySearch(searchNum)
                        Thread {
                            StepControls.initiateStep()
                            tree?.execute()
                            StepControls.endStep()
                        }.start()

                        if (searchAnswer == userSelectedNodes.toString()) {
                            testNodes.setTextColor(Color.GREEN)
                        } else {
                            testNodes.setTextColor(Color.RED)
                        }
                    } else {
                        val searchAnswer = bfsDIY().toString()
                        testNodes.text = "Search Path is: " + searchAnswer.substring(
                            1,
                            searchAnswer.length - 1
                        )
                        val searchNum: Int = input!!.text.toString().toInt()
                        tree?.performBfs(searchNum)
                        Thread {
                            StepControls.initiateStep()
                            tree?.execute()
                            StepControls.endStep()
                        }.start()

                        if (searchAnswer == userSelectedNodes.toString()) {
                            testNodes.setTextColor(Color.GREEN)
                        } else {
                            testNodes.setTextColor(Color.RED)
                        }
                    }

                }

                if (inorderButton.currentTextColor == Color.WHITE) {
                    tree?.getTraversalNodesDisplayed()?.clear()
                    tree?.performInOrder()
                    Thread {
                        StepControls.initiateStep()
                        tree?.execute()
                        StepControls.endStep()
                    }.start()
                    tree!!.resetCurrentNodePath()
                    tree!!.draw()
                    tree?.exploredNodesInOrder(tree?.root)
                    val inOrderAnswer = tree?.getTraversalNodesDisplayed().toString()
                    testNodes.text = "In-Order traversal is: " + inOrderAnswer.substring(
                        1,
                        inOrderAnswer.length - 1
                    )

                    if (inOrderAnswer == userSelectedNodes.toString()) {
                        testNodes.setTextColor(Color.GREEN)
                    } else {
                        testNodes.setTextColor(Color.RED)
                    }
                }

                if (preorderButton.currentTextColor == Color.WHITE) {
                    tree?.getTraversalNodesDisplayed()?.clear()
                    tree?.performPreOrder()
                    Thread {
                        StepControls.initiateStep()
                        tree?.execute()
                        StepControls.endStep()
                    }.start()
                    tree!!.resetCurrentNodePath()
                    tree!!.draw()
                    tree?.exploredNodesPreOrder(tree?.root)
                    val preOrderAnswer = tree?.getTraversalNodesDisplayed().toString()
                    testNodes.text = "Pre-Order traversal is: " + preOrderAnswer.substring(
                        1,
                        preOrderAnswer.length - 1
                    )
                    if (preOrderAnswer == userSelectedNodes.toString()) {
                        testNodes.setTextColor(Color.GREEN)
                    } else {
                        testNodes.setTextColor(Color.RED)
                    }

                }

                if (postorderButton.currentTextColor == Color.WHITE) {
                    tree?.getTraversalNodesDisplayed()?.clear()
                    tree?.performPostOrder()
                    Thread {
                        StepControls.initiateStep()
                        tree?.execute()
                        StepControls.endStep()
                    }.start()
                    tree!!.resetCurrentNodePath()
                    tree!!.draw()
                    tree?.exploredNodesPostOrder(tree?.root)
                    val postOrderAnswer = tree?.getTraversalNodesDisplayed().toString()
                    testNodes.text = "Post-Order traversal is: " + postOrderAnswer.substring(
                        1,
                        postOrderAnswer.length - 1
                    )
                    if (postOrderAnswer == userSelectedNodes.toString()) {
                        testNodes.setTextColor(Color.GREEN)
                    } else {
                        testNodes.setTextColor(Color.RED)
                    }
                }
            }
        }


        if (topic == "Nary Tree") {
            number3.setOnClickListener(View.OnClickListener {
                NaryTree.setNumChildrenProperty(3)
                number3.setBackgroundResource(R.drawable.round_bt_blue)
                number3.setTextColor(Color.WHITE)
                number4.setBackgroundResource(R.drawable.round_bt)
                number4.setTextColor(Color.BLACK)
                number5.setBackgroundResource(R.drawable.round_bt)
                number5.setTextColor(Color.BLACK)
            })
            number4.setOnClickListener(View.OnClickListener {
                NaryTree.setNumChildrenProperty(4)
                number4.setBackgroundResource(R.drawable.round_bt_blue)
                number4.setTextColor(Color.WHITE)
                number3.setBackgroundResource(R.drawable.round_bt)
                number3.setTextColor(Color.BLACK)
                number5.setBackgroundResource(R.drawable.round_bt)
                number5.setTextColor(Color.BLACK)
            })
            number5.setOnClickListener(View.OnClickListener {
                NaryTree.setNumChildrenProperty(5)
                number5.setBackgroundResource(R.drawable.round_bt_blue)
                number5.setTextColor(Color.WHITE)
                number4.setBackgroundResource(R.drawable.round_bt)
                number4.setTextColor(Color.BLACK)
                number3.setBackgroundResource(R.drawable.round_bt)
                number3.setTextColor(Color.BLACK)
            })


        }


        displayTree = view.findViewById(R.id.TreeDisplay)
        displayTree?.doOnLayout {
            checkCanvas()
            if (!loadTree.isNullOrEmpty()) {
                loadFullTree(loadTree!!)
            }
        }
        displayTree?.updateDIY(this)


        displayTree?.setOnTouchListener { _, event ->
            val xCoordinate = event.x.toInt()
            val yCoordinate = event.y.toInt()
            println("x: $xCoordinate, y: $yCoordinate")

            val node = tree?.getUserSelectedNode(xCoordinate, yCoordinate)
            val nodeColor = tree?.getColourOfSelectedNode(xCoordinate, yCoordinate)
            nodeColor?.let { tree?.changeNodeColour(it, MainActivity.getCanvas()) }

            if (!userSelectedNodes.contains(node) && node != -1) {

                node?.toInt()?.let { userSelectedNodes.add(it) }
                selectedNodes.text = "Selected Nodes: " + userSelectedNodes.toString()
                    .substring(1, userSelectedNodes.toString().length - 1)
            }
            false
        }


        insertButton.setBackgroundResource(R.drawable.round_bt_blue)
        deleteButton.setTextColor(Color.BLACK)
        searchButton.setTextColor(Color.BLACK)
        preorderButton.setTextColor(Color.BLACK)
        inorderButton.setTextColor(Color.BLACK)
        postorderButton.setTextColor(Color.BLACK)


        insertButton.setOnClickListener {
            insertButton.setBackgroundResource(R.drawable.round_bt_blue)
            insertButton.setTextColor(Color.WHITE)
            deleteButton.setBackgroundResource(R.drawable.round_bt)
            searchButton.setBackgroundResource(R.drawable.round_bt)
            deleteButton.setTextColor(Color.BLACK)
            searchButton.setTextColor(Color.BLACK)
            inorderButton.setBackgroundResource(R.drawable.round_bt)
            inorderButton.setTextColor(Color.BLACK)
            preorderButton.setBackgroundResource(R.drawable.round_bt)
            preorderButton.setTextColor(Color.BLACK)
            postorderButton.setBackgroundResource(R.drawable.round_bt)
            postorderButton.setTextColor(Color.BLACK)
            testNodes.setTextColor(Color.BLACK)
            testNodes.text = ""
            userSelectedNodes.clear()
            selectedNodes.text = "Selected Nodes: "
            tree?.draw()
        }

        deleteButton.setOnClickListener {
            deleteButton.setBackgroundResource(R.drawable.round_bt_blue)
            deleteButton.setTextColor(Color.WHITE)
            insertButton.setBackgroundResource(R.drawable.round_bt)
            searchButton.setBackgroundResource(R.drawable.round_bt)
            insertButton.setTextColor(Color.BLACK)
            searchButton.setTextColor(Color.BLACK)
            inorderButton.setBackgroundResource(R.drawable.round_bt)
            inorderButton.setTextColor(Color.BLACK)
            preorderButton.setBackgroundResource(R.drawable.round_bt)
            preorderButton.setTextColor(Color.BLACK)
            postorderButton.setBackgroundResource(R.drawable.round_bt)
            postorderButton.setTextColor(Color.BLACK)
            testNodes.setTextColor(Color.BLACK)
            testNodes.text = ""
            userSelectedNodes.clear()
            selectedNodes.text = "Selected Nodes: "
            tree?.draw()

        }

        searchButton.setOnClickListener {
            searchButton.setBackgroundResource(R.drawable.round_bt_blue)
            searchButton.setTextColor(Color.WHITE)
            insertButton.setBackgroundResource(R.drawable.round_bt)
            deleteButton.setBackgroundResource(R.drawable.round_bt)
            insertButton.setTextColor(Color.BLACK)
            deleteButton.setTextColor(Color.BLACK)
            inorderButton.setBackgroundResource(R.drawable.round_bt)
            inorderButton.setTextColor(Color.BLACK)
            preorderButton.setBackgroundResource(R.drawable.round_bt)
            preorderButton.setTextColor(Color.BLACK)
            postorderButton.setBackgroundResource(R.drawable.round_bt)
            postorderButton.setTextColor(Color.BLACK)
            testNodes.setTextColor(Color.BLACK)
            testNodes.text = ""
            userSelectedNodes.clear()
            selectedNodes.text = "Selected Nodes: "
            tree?.draw()
        }


        inorderButton.setOnClickListener {
            inorderButton.setBackgroundResource(R.drawable.round_bt_blue)
            inorderButton.setTextColor(Color.WHITE)
            preorderButton.setBackgroundResource(R.drawable.round_bt)
            postorderButton.setBackgroundResource(R.drawable.round_bt)
            preorderButton.setTextColor(Color.BLACK)
            postorderButton.setTextColor(Color.BLACK)
            searchButton.setBackgroundResource(R.drawable.round_bt)
            searchButton.setTextColor(Color.BLACK)
            deleteButton.setBackgroundResource(R.drawable.round_bt)
            deleteButton.setTextColor(Color.BLACK)
            insertButton.setBackgroundResource(R.drawable.round_bt)
            insertButton.setTextColor(Color.BLACK)
            tree?.getTraversalNodesDisplayed()?.clear()
            testNodes.setTextColor(Color.BLACK)
            testNodes.text = ""
            userSelectedNodes.clear()
            selectedNodes.text = "Selected Nodes: "
            tree?.draw()

        }

        preorderButton.setOnClickListener {
            preorderButton.setBackgroundResource(R.drawable.round_bt_blue)
            preorderButton.setTextColor(Color.WHITE)
            inorderButton.setBackgroundResource(R.drawable.round_bt)
            postorderButton.setBackgroundResource(R.drawable.round_bt)
            inorderButton.setTextColor(Color.BLACK)
            postorderButton.setTextColor(Color.BLACK)
            searchButton.setBackgroundResource(R.drawable.round_bt)
            searchButton.setTextColor(Color.BLACK)
            deleteButton.setBackgroundResource(R.drawable.round_bt)
            deleteButton.setTextColor(Color.BLACK)
            insertButton.setBackgroundResource(R.drawable.round_bt)
            insertButton.setTextColor(Color.BLACK)
            tree?.getTraversalNodesDisplayed()?.clear()
            testNodes.setTextColor(Color.BLACK)
            testNodes.text = ""
            userSelectedNodes.clear()
            selectedNodes.text = "Selected Nodes: "
            tree?.draw()

        }

        postorderButton.setOnClickListener {
            postorderButton.setBackgroundResource(R.drawable.round_bt_blue)
            postorderButton.setTextColor(Color.WHITE)
            inorderButton.setBackgroundResource(R.drawable.round_bt)
            preorderButton.setBackgroundResource(R.drawable.round_bt)
            inorderButton.setTextColor(Color.BLACK)
            preorderButton.setTextColor(Color.BLACK)
            searchButton.setBackgroundResource(R.drawable.round_bt)
            searchButton.setTextColor(Color.BLACK)
            deleteButton.setBackgroundResource(R.drawable.round_bt)
            deleteButton.setTextColor(Color.BLACK)
            insertButton.setBackgroundResource(R.drawable.round_bt)
            insertButton.setTextColor(Color.BLACK)
            tree?.getTraversalNodesDisplayed()?.clear()
            testNodes.setTextColor(Color.BLACK)
            testNodes.text = ""
            userSelectedNodes.clear()
            selectedNodes.text = "Selected Nodes: "
            tree?.draw()

        }
    }


    private fun setTopic() {
        when (topic) {

            "Binary Tree" -> {
                tree = BinaryTree()
            }
            "Binary Search Tree" -> {
                tree = BinarySearchTree()
            }
            "AVL Tree" -> {
                tree = AVLTree()
            }
            "Nary Tree" -> {
                tree = NaryTree()
            }
            "Linear List to BST" -> {
                tree = BinarySearchTree()
            }
        }
    }

    private fun createMovementButtons(view: View) {
        val backButton = view.findViewById<ImageButton>(R.id.back_button)
        val restartButton = view.findViewById<ImageButton>(R.id.restartButton)
        val previousButton = view.findViewById<ImageButton>(R.id.previousButton)
        val pauseButton = view.findViewById<ImageButton>(R.id.pauseButton)
        val nextButton = view.findViewById<ImageButton>(R.id.nextButton)
        val endButton = view.findViewById<ImageButton>(R.id.endButton)
        val playButton = view.findViewById<ImageButton>(R.id.playButton)

        pauseButton.setOnClickListener {
            tree?.pause()
            StepControls.pauseStep = true
            Thread {
                StepControls.pauseStep = true
            }.start()
            playButton.visibility = View.VISIBLE
            pauseButton.visibility = View.GONE
        }
        playButton.setOnClickListener {
           tree?.resume()
            Thread {
                StepControls.initiateStep()
                tree?.execute()
                StepControls.endStep()
            }.start()
            playButton.visibility = View.GONE
            pauseButton.visibility = View.VISIBLE
        }

        previousButton.setOnClickListener {
            tree!!.stepBackwards()
        }
        nextButton.setOnClickListener {
            tree!!.stepForward()
        }
        endButton.setOnClickListener {
            tree!!.repeatAction()
        }
        restartButton.setOnClickListener {
            tree!!.revertAction()
        }


        backButton.setOnClickListener {
            StepControls.resetAllSteps()
            MainActivity.openFragment(Home())
        }

        val seekBar = view.findViewById<SeekBar>(R.id.seekbar)
        val valueIndex = view.findViewById<MaterialTextView>(R.id.valueIndex)

        val stepSize = 0.25f
        val minValue = 0.25f
        val maxValue = 2f
        val numSteps = ((maxValue - minValue) / stepSize).toInt()
        val defaultValue = 1f
        val defaultIndex = ((defaultValue - minValue) / stepSize).toInt()
        seekBar.progress = defaultIndex
        seekBar.max = numSteps - 0.75f.toInt()

        StepControls.duration = 1000

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                StepControls.duration = when (seekBar?.progress) {
                    0 -> 2000
                    1 -> 1750
                    2 -> 1500
                    3 -> 1250
                    4 -> 1000
                    5 -> 750
                    6 -> 500
                    7 -> 250
                    else -> 1000
                }
                val value = minValue + progress * stepSize
                valueIndex.text = "$value X"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }


    private fun insert() {

        tree!!.insertAction(
            input!!.text.toString().toInt()
        )
        input!!.setText("")

    }

    private fun insertDIY(): ArrayList<Int> {


        return tree!!.exploredNodesInsert(
            input!!.text.toString().toInt()
        )
    }

    private fun delete() {

        tree!!.deleteAction(
            input!!.text.toString().toInt()
        )
        input!!.setText("")
    }

    private fun deleteDIY(): ArrayList<Int> {

        return tree!!.exploredNodesDelete(
            input!!.text.toString().toInt()
        )
    }

    private fun binarySearchDIY(): ArrayList<Int> {

        return tree!!.exploredNodesBinarySearch(
            input!!.text.toString().toInt(), tree!!.root
        )
    }

    private fun bfsDIY(): ArrayList<Int> {

        val diyAnswer = tree!!.exploredNodesBfs(
            input!!.text.toString().toInt(), tree!!.root
        )
        return diyAnswer
    }

    private fun loadFullTree(treeValues: ArrayList<Int>) {

        for (i in treeValues.indices) {
            tree!!.loadTree(treeValues[i])
        }
    }


    fun setSurface(bitmap: Bitmap?) {
        displayTree?.background = bitmap?.let { BitmapDrawable(it) }
    }


    private fun checkCanvas() {
        if (displayTree!!.canvas == null) {
            val vHeight = displayTree!!.height
            val vWidth = displayTree!!.width
            if (vHeight > 0 && vWidth > 0) {
                displayTree!!.setSurfaceSize(vHeight, vWidth)
            }
        }
    }

    companion object {
        var tree: TreeLayout? = null
    }
}