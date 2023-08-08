package com.example.treevisualisationandalgorithms.datastructures
import java.util.*

class Node constructor(var key: Int, n: Int) {

    var children: ArrayList<Node?> = ArrayList<Node?>(Collections.nCopies(n, null))
    var startingCoordinates: IntArray = IntArray(2)
    var finalCoordinates: IntArray = IntArray(2)
    var nodeHeight: Int = 0
    var balanceFactor = 0

}


