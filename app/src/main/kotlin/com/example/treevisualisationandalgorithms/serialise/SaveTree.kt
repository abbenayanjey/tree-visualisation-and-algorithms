package com.example.treevisualisationandalgorithms.serialise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.example.treevisualisationandalgorithms.R
import com.example.treevisualisationandalgorithms.renderTree.TreeLayout
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter


class SaveTree : BottomSheetDialogFragment() {
    private var tree: TreeLayout? = null
    private var treeName: EditText? = null


    fun setTree(tree: TreeLayout?) {
        this.tree = tree
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.save_tree, container)
        treeName = view.findViewById<EditText>(R.id.setTreeNameField)
        val saveButton = view.findViewById<AppCompatButton>(R.id.confirmSaveTreeButton)
        val cancelButton = view.findViewById<AppCompatButton>(R.id.cancelSaveTreeButton)

        saveButton?.setOnClickListener {
            if (treeName?.text.isNullOrEmpty()) {
                return@setOnClickListener
            } else {
                serialiseTrees()
                dismiss()
            }
        }

        cancelButton?.setOnClickListener { dismiss() }
        return view
    }

    private fun serialiseTrees() {
        val context = context ?: return
        val treeObj = when (topic) {
            "Binary Search Tree" -> tree?.serialise("Binary Search Tree")
            "AVL Tree" -> tree?.serialise("AVL Tree")
            "Binary Tree" -> tree?.serialise("Binary Tree")
            "Nary Tree" -> tree?.serialise("Nary Tree")
            "Linear List to BST" -> tree?.serialise("Binary Search Tree")
            else -> null
        }
        treeObj ?: return

        val saveTree = File(context.filesDir, treeName!!.text.toString())
        if (saveTree.exists()) {
            return
        }
        val writer = FileWriter(saveTree)
        val bufferedWriter = BufferedWriter(writer)
        bufferedWriter.write(treeObj.toString())
        bufferedWriter.close()

    }

    companion object {
        private var topic: String? = null

        fun setTopic(topic: String?) {
            Companion.topic = topic
        }
    }
}