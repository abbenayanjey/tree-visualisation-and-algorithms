package com.example.treevisualisationandalgorithms.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.treevisualisationandalgorithms.MainActivity
import com.example.treevisualisationandalgorithms.R

class Home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val homeScreen = inflater.inflate(R.layout.home_screen, container, false)
        val binaryTopic = homeScreen.findViewById<Button>(R.id.binaryButton)
        val bstTopic = homeScreen.findViewById<Button>(R.id.bstButton)
        val avlTopic = homeScreen.findViewById<Button>(R.id.avlButton)
        val naryTopic = homeScreen.findViewById<Button>(R.id.naryButton)
        val listToBstTopic = homeScreen.findViewById<Button>(R.id.listButton)


        binaryTopic?.setOnClickListener {
            MainActivity.openFragment(
                Visualiser("Binary Tree")
            )
        }
        bstTopic?.setOnClickListener {
            MainActivity.openFragment(
                Visualiser("Binary Search Tree")
            )
        }
        avlTopic?.setOnClickListener {
            MainActivity.openFragment(
                Visualiser("AVL Tree")
            )
        }
        naryTopic?.setOnClickListener {
            MainActivity.openFragment(
                Visualiser("Nary Tree")
            )
        }

        listToBstTopic?.setOnClickListener {
            MainActivity.openFragment(
                Visualiser("Linear List to BST")
            )
        }

        return homeScreen
    }

}