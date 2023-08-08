package com.example.treevisualisationandalgorithms.serialise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.treevisualisationandalgorithms.MainActivity
import com.example.treevisualisationandalgorithms.R
import com.example.treevisualisationandalgorithms.renderTree.TreeLayout
import com.example.treevisualisationandalgorithms.screens.DIY
import com.example.treevisualisationandalgorithms.screens.Visualiser
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.json.JSONObject
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class LoadTree(private val topic: String?, private val callingFragment: Fragment) :
    BottomSheetDialogFragment() {
    private lateinit var treeRecyclerView: RecyclerView
    private lateinit var allTrees: ArrayList<Tree>
    private var tree: TreeLayout? = null


    fun setTree(tree: TreeLayout?) {
        this.tree = tree
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.load_tree_view, container, false)
        treeRecyclerView = view.findViewById(R.id.treeRecyclerView)
        treeRecyclerView.setHasFixedSize(true)
        treeRecyclerView.layoutManager = LinearLayoutManager(activity)
        allTrees = getTreeDetails()?.let { deserialiseTrees(it) } ?: arrayListOf()
        loadTreeView = LoadTreeView(allTrees)
        treeRecyclerView.adapter = loadTreeView
        allTrees.add(
            Tree(
                "Binary Tree Example",
                "Binary Tree",
                ArrayList<Int>(15).apply { for (i in 1..15) add(i) })
        )
        allTrees.add(
            Tree(
                "3-ary Tree Example",
                "Nary Tree",
                ArrayList<Int>(13).apply { for (i in 1..13) add(i) })
        )
        allTrees.add(
            Tree(
                "4-ary Tree Example",
                "Nary Tree",
                ArrayList<Int>(21).apply { for (i in 1..21) add(i) })
        )
        allTrees.add(
            Tree(
                "5-ary Tree Example",
                "Nary Tree",
                ArrayList<Int>(31).apply { for (i in 1..31) add(i) })
        )
        allTrees.add(
            Tree(
                "Binary Search Tree Example",
                "Binary Search Tree",
                arrayListOf(10, 5, 15, 3, 8, 12, 20, 1, 4, 7, 9, 11, 14, 18, 25)
            )
        )
        allTrees.add(
            Tree(
                "AVL Tree Example",
                "AVL Tree",
                ArrayList<Int>(9).apply { for (i in 1..9) add(i) })
        )

        loadTreeView.setOnItemClickListener(object : LoadTreeView.onItemClickListener {

            override fun onItemClick(position: Int) {
                dismiss()
                val treeFragment: Fragment = if (callingFragment is Visualiser) {
                    Visualiser(
                        loadTreeView.getItem(position).treeTopic.toString(),
                        loadTreeView.getItem(position).treeKeys
                    )
                } else {
                    DIY(
                        loadTreeView.getItem(position).treeTopic.toString(),
                        loadTreeView.getItem(position).treeKeys
                    )
                }
                MainActivity.openFragment(treeFragment)
            }


        })
        if (topic != null) {
            allTrees.filter { it.treeTopic != topic }.forEach { allTrees.remove(it) }
        }
        return view
    }

    private fun getTreeDetails(): Array<out File>? {
        val directory = context?.filesDir
        return directory?.listFiles()
    }

    private fun deserialiseTrees(trees: Array<out File>): ArrayList<Tree> {
        return ArrayList(trees.map { loadTree ->
            val topic: String?
            val tree = Tree()
            val fileReader = FileReader(loadTree)
            val bufferedReader = BufferedReader(fileReader)
            val stringBuilder = StringBuilder()
            var line: String? = bufferedReader.readLine()
            while (line != null) {
                stringBuilder.append(line).append("\n")
                line = bufferedReader.readLine()
            }
            bufferedReader.close()
            val response = stringBuilder.toString()
            val treeObject = JSONObject(response)
            val values = treeObject.optJSONArray("Values")
            topic = treeObject.optString("Type")
            val arr = ArrayList<Int>()
            if (values != null) {
                for (j in 0 until values.length()) {
                    arr.add(values.optInt(j))
                }
            }
            tree.treeKeys = arr
            if (topic != null) {
                tree.treeTopic = topic
            }
            tree.treeName = loadTree.name
            tree
        })
    }

    companion object {

        lateinit var loadTreeView: LoadTreeView
            private set
    }
}