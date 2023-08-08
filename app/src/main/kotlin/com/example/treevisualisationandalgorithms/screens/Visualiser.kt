package com.example.treevisualisationandalgorithms.screens

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
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
import com.example.treevisualisationandalgorithms.serialise.SaveTree
import com.example.treevisualisationandalgorithms.serialise.SaveTree.Companion.setTopic
import com.google.android.material.textview.MaterialTextView


class Visualiser : Fragment {

    private var input: EditText? = null
    private var inputList: EditText? = null
    private var topic: String? = null
    private var displayTree: DisplayTree? = null
    private var loadTree: ArrayList<Int>? = null


    override fun onResume() {
        super.onResume()

        displayTree?.updateVisualiser(this)
        MainActivity.setVisualizerCanvas(displayTree)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View
        val selectedTopic = when (topic) {
            "Binary Tree" -> R.layout.binary_screen
            "Nary Tree" -> R.layout.nary_screen
            "Binary Search Tree" -> R.layout.bst_screen
            "AVL Tree" -> R.layout.avl_screen
            "Linear List to BST" -> R.layout.list_to_bst_screen
            else -> {
                R.layout.home_screen
            }
        }

        view = inflater.inflate(selectedTopic, container, false)

        when (selectedTopic) {
            R.layout.binary_screen, R.layout.nary_screen, R.layout.bst_screen, R.layout.avl_screen, R.layout.list_to_bst_screen -> {
                createTreeOperationsAndAlgorithms(view)
                createModeSwitchButtons(view)
                createMovementButtons(view)
                createTreeManagementButtons(view)
                setTopic()
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

        visualiserButton.setBackgroundResource(R.drawable.round_bt_blue)
        diyButton.setTextColor(Color.BLACK)
        visualiserButton.setOnClickListener {
            visualiserButton.setBackgroundResource(R.drawable.round_bt_blue)
            visualiserButton.setTextColor(Color.WHITE)
            diyButton.setBackgroundResource(R.drawable.round_bt)
            diyButton.setTextColor(Color.BLACK)
        }

        diyButton.setOnClickListener {
            diyButton.setBackgroundResource(R.drawable.round_bt_blue)
            diyButton.setTextColor(Color.WHITE)
            visualiserButton.setBackgroundResource(R.drawable.round_bt)
            visualiserButton.setTextColor(Color.BLACK)
            MainActivity.openFragment(DIY(topic.toString()))
            StepControls.resetAllSteps()
            tree?.resetTree()
            tree = null
        }
    }


    @SuppressLint("SetTextI18n")
    private fun createTreeOperationsAndAlgorithms(view: View) {

        input = view.findViewById(R.id.input_nodes)
        inputList = view.findViewById(R.id.input_list)
        val insertNode = view.findViewById<ImageButton>(R.id.button_insert)
        val deleteNode = view.findViewById<ImageButton>(R.id.button_delete)
        val searchNode = view.findViewById<ImageButton>(R.id.button_search)
        val insertListButton = view.findViewById<ImageButton>(R.id.button_list_insert)
        val insertButton = view.findViewById<AppCompatButton>(R.id.insertButton)
        val deleteButton = view.findViewById<AppCompatButton>(R.id.deleteButton)
        val searchButton = view.findViewById<AppCompatButton>(R.id.searchButton)
        val inorderButton = view.findViewById<AppCompatButton>(R.id.inorderButton)
        val preorderButton = view.findViewById<AppCompatButton>(R.id.preorderButton)
        val postorderButton = view.findViewById<AppCompatButton>(R.id.postorderButton)
        val traversalOrder = view.findViewById<TextView>(R.id.traversal_order)
        val number3 = view.findViewById<AppCompatButton>(R.id.number3)
        val number4 = view.findViewById<AppCompatButton>(R.id.number4)
        val number5 = view.findViewById<AppCompatButton>(R.id.number5)


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
            if (topic != "Linear List to BST") {
                insertNode.visibility = View.VISIBLE
            } else {
                insertListButton.visibility = View.VISIBLE
            }
            deleteNode.visibility = View.GONE
            searchNode.visibility = View.GONE
            input?.visibility = View.VISIBLE

        }

        deleteButton.setOnClickListener {
            deleteButton.setBackgroundResource(R.drawable.round_bt_blue)
            deleteButton.setTextColor(Color.WHITE)
            insertButton.setBackgroundResource(R.drawable.round_bt)
            searchButton.setBackgroundResource(R.drawable.round_bt)
            insertButton.setTextColor(Color.BLACK)
            searchButton.setTextColor(Color.BLACK)
            if (topic != "Linear List to BST") {
                insertNode.visibility = View.GONE
            } else {
                insertListButton.visibility = View.VISIBLE
            }
            deleteNode.visibility = View.VISIBLE
            searchNode.visibility = View.GONE

            input?.visibility = View.VISIBLE

        }

        searchButton.setOnClickListener {
            searchButton.setBackgroundResource(R.drawable.round_bt_blue)
            searchButton.setTextColor(Color.WHITE)
            insertButton.setBackgroundResource(R.drawable.round_bt)
            deleteButton.setBackgroundResource(R.drawable.round_bt)
            insertButton.setTextColor(Color.BLACK)
            deleteButton.setTextColor(Color.BLACK)
            if (topic != "Linear List to BST") {
                insertNode.visibility = View.GONE
            } else {
                insertListButton.visibility = View.VISIBLE
            }
            deleteNode.visibility = View.GONE
            searchNode.visibility = View.VISIBLE

            input?.visibility = View.VISIBLE
        }


        inorderButton.setOnClickListener {
            inorderButton.setBackgroundResource(R.drawable.round_bt_blue)
            inorderButton.setTextColor(Color.WHITE)
            preorderButton.setBackgroundResource(R.drawable.round_bt)
            postorderButton.setBackgroundResource(R.drawable.round_bt)
            preorderButton.setTextColor(Color.BLACK)
            postorderButton.setTextColor(Color.BLACK)
            tree?.getTraversalNodesDisplayed()?.clear()
            tree?.performInOrder()
            Thread {
                StepControls.initiateStep()
                tree?.execute()
                StepControls.endStep()
                tree?.exploredNodesInOrder(tree?.root)
                val order = tree?.getTraversalNodesDisplayed().toString()
                val handler = Handler(Looper.getMainLooper())
                handler.post {
                    traversalOrder.text =
                        "In-Order traversal  is: " + order.substring(1, order.length - 1)
                }
            }.start()
            tree!!.resetCurrentNodePath()
            tree!!.draw()
        }

        preorderButton.setOnClickListener {
            preorderButton.setBackgroundResource(R.drawable.round_bt_blue)
            preorderButton.setTextColor(Color.WHITE)
            inorderButton.setBackgroundResource(R.drawable.round_bt)
            postorderButton.setBackgroundResource(R.drawable.round_bt)
            inorderButton.setTextColor(Color.BLACK)
            postorderButton.setTextColor(Color.BLACK)
            tree?.getTraversalNodesDisplayed()?.clear()
            tree?.performPreOrder()
            Thread {
                StepControls.initiateStep()
                tree?.execute()
                StepControls.endStep()
                tree?.exploredNodesPreOrder(tree?.root)
                val order = tree?.getTraversalNodesDisplayed().toString()
                val handler = Handler(Looper.getMainLooper())
                handler.post {
                    traversalOrder.text =
                        "Pre-Order traversal  is: " + order.substring(1, order.length - 1)
                }
            }.start()
            tree!!.resetCurrentNodePath()
            tree!!.draw()

        }

        postorderButton.setOnClickListener {
            postorderButton.setBackgroundResource(R.drawable.round_bt_blue)
            postorderButton.setTextColor(Color.WHITE)
            inorderButton.setBackgroundResource(R.drawable.round_bt)
            preorderButton.setBackgroundResource(R.drawable.round_bt)
            inorderButton.setTextColor(Color.BLACK)
            preorderButton.setTextColor(Color.BLACK)
            tree?.getTraversalNodesDisplayed()?.clear()
            tree?.performPostOrder()
            Thread {
                StepControls.initiateStep()
                tree?.execute()
                StepControls.endStep()
                tree?.exploredNodesPostOrder(tree?.root)
                val order = tree?.getTraversalNodesDisplayed().toString()
                val handler = Handler(Looper.getMainLooper())
                handler.post {
                    traversalOrder.text = "Post-Order traversal  is: " + order.substring(
                        1,
                        order.length - 1
                    )
                }
            }.start()
            tree!!.resetCurrentNodePath()
            tree!!.draw()

        }


        if (topic == "Nary Tree") {
            number3.setOnClickListener {
                NaryTree.setNumChildrenProperty(3)
                number3.setBackgroundResource(R.drawable.round_bt_blue)
                number3.setTextColor(Color.WHITE)
                number4.setBackgroundResource(R.drawable.round_bt)
                number4.setTextColor(Color.BLACK)
                number5.setBackgroundResource(R.drawable.round_bt)
                number5.setTextColor(Color.BLACK)
            }
            number4.setOnClickListener {
                NaryTree.setNumChildrenProperty(4)
                number4.setBackgroundResource(R.drawable.round_bt_blue)
                number4.setTextColor(Color.WHITE)
                number3.setBackgroundResource(R.drawable.round_bt)
                number3.setTextColor(Color.BLACK)
                number5.setBackgroundResource(R.drawable.round_bt)
                number5.setTextColor(Color.BLACK)
            }
            number5.setOnClickListener {
                NaryTree.setNumChildrenProperty(5)
                number5.setBackgroundResource(R.drawable.round_bt_blue)
                number5.setTextColor(Color.WHITE)
                number4.setBackgroundResource(R.drawable.round_bt)
                number4.setTextColor(Color.BLACK)
                number3.setBackgroundResource(R.drawable.round_bt)
                number3.setTextColor(Color.BLACK)
            }

        }


        displayTree = view.findViewById(R.id.TreeDisplay)
        displayTree?.doOnLayout {
            checkCanvas()
            if (!loadTree.isNullOrEmpty()) {
                loadFullTree(loadTree!!)
            }
        }
        displayTree?.updateVisualiser(this)


        if (topic != "Linear List to BST") {


            insertNode.setOnClickListener {
                if (input?.text?.length != 0 || input?.text.toString()
                        .toInt() < 100
                ) {
                    insert()
                }
            }
        }
        deleteNode.setOnClickListener {
            if (input?.text?.length != 0 || input?.text.toString()
                    .toInt() < 100
            ) {
                delete()
            }
        }


        searchNode.setOnClickListener {

            if (input != null && input!!.text.toString().isNotEmpty()) {
                val searchNum: Int = input!!.text.toString().toInt()
                when (topic) {
                    "Binary Tree" -> {
                        tree?.performBfs(searchNum)
                    }
                    "Binary Search Tree" -> {
                        tree?.performBinarySearch(searchNum)
                    }
                    "AVL Tree" -> {
                        tree?.performBinarySearch(searchNum)

                    }
                    "Nary Tree" -> {
                        tree?.performBfs(searchNum)

                    }
                    "Linear List to BST" -> {
                        tree?.performBinarySearch(searchNum)

                    }
                }

                Thread {
                    StepControls.initiateStep()
                    tree?.execute()
                    StepControls.endStep()
                }.start()
            }

        }





        if (topic == "Linear List to BST") {
            insertListButton.setOnClickListener {
                insertLinearList()
            }

            deleteNode.setOnClickListener {
                if (inputList?.text?.length != 0 || inputList?.text.toString()
                        .toInt() < 100
                ) {
                    delete()
                }
            }

            searchNode.setOnClickListener {

                if (inputList != null && inputList!!.text.toString().isNotEmpty()) {
                    val searchNum: Int = inputList!!.text.toString().toInt()
                    when (topic) {

                        "Linear List to BST" -> {
                            tree?.performBinarySearch(searchNum)

                        }
                    }

                    Thread {
                        StepControls.initiateStep()
                        tree?.execute()
                        StepControls.endStep()
                    }.start()
                }

            }
        }

    }


    private fun convertUserInputToLinearList(input: String): ArrayList<Int> {
        val parts = input.split(",")
        val result = ArrayList<Int>()

        for (part in parts) {
            try {
                val num = part.trim().toInt()
                result.add(num)
            } catch (_: NumberFormatException) {

            }
        }
        return result
    }


    private fun createTreeManagementButtons(view: View) {

        val loadButton = view.findViewById<Button>(R.id.button_load)
        val saveButton = view.findViewById<Button>(R.id.button_save)
        val clearButton = view.findViewById<Button>(R.id.button_delete_all)

        saveButton.setOnClickListener {
            val transaction = childFragmentManager.beginTransaction()
            childFragmentManager.findFragmentByTag("Load Visualiser")?.let {
                transaction.remove(it)
            }
            transaction.addToBackStack(null)
            val saveTree = SaveTree()
            saveTree.setTree(tree)
            setTopic(topic)
            saveTree.show(transaction, "Save Visualiser")
        }

        loadButton.setOnClickListener {


            val transaction = childFragmentManager.beginTransaction()
            childFragmentManager.findFragmentByTag("Load Visualiser")?.let {
                transaction.remove(it)
            }
            transaction.addToBackStack(null)
            val loadTree = LoadTree(topic, this)
            loadTree.setTree(tree)
            setTopic(topic)
            loadTree.show(transaction, "Load Visualiser")

        }

        clearButton.setOnClickListener {
            clear()
        }
    }

    private fun clear() {

        if (tree != null) {
            tree!!.deleteAllNodes()
            tree!!.root?.let { tree!!.deleteNode(it.key) }
        }
        if (displayTree != null) {
            displayTree!!.resetSurface()
            checkCanvas()

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


    private fun insert() {

        tree!!.insertAction(
            input!!.text.toString().toInt()
        )
        input!!.setText("")

    }

    private fun insertLinearList() {

        tree!!.insertAction(
            convertUserInputToLinearList(inputList!!.text.toString())
        )
        inputList!!.setText("")
    }

    private fun delete() {

        if (topic == "Linear List to BST") {
            tree!!.deleteAction(
                inputList!!.text.toString().toInt()
            )
            inputList!!.setText("")
        } else {

            tree!!.deleteAction(
                input!!.text.toString().toInt()
            )
            input!!.setText("")
        }
    }

    private fun loadFullTree(treeValues: ArrayList<Int>) {
        for (i in treeValues.indices) {
            tree!!.loadTree(treeValues[i])
        }
    }


    fun setCanvas(bitmap: Bitmap?) {
        displayTree?.background = bitmap?.let { BitmapDrawable(it) }
    }


    fun checkCanvas() {
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