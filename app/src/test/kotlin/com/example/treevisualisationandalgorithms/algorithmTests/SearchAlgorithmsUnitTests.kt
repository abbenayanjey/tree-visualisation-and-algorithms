package com.example.treevisualisationandalgorithms.algorithmTests

import com.example.treevisualisationandalgorithms.datastructures.AVLTree
import com.example.treevisualisationandalgorithms.datastructures.BinarySearchTree
import com.example.treevisualisationandalgorithms.datastructures.BinaryTree
import com.example.treevisualisationandalgorithms.datastructures.NaryTree
import junit.framework.TestCase

class SearchAlgorithmsUnitTests: TestCase() {

    fun testBinaryTreeBfs() {
        val binary = BinaryTree()
        binary.loadTree(1)
        binary.loadTree(2)
        binary.loadTree(3)
        binary.loadTree(4)
        binary.loadTree(5)
        binary.loadTree(6)
        binary.loadTree(7)
        binary.loadTree(8)
        binary.loadTree(9)
        binary.loadTree(10)
        binary.loadTree(11)
        binary.loadTree(12)
        binary.loadTree(13)
        binary.loadTree(14)
        binary.loadTree(15)
        val result = binary.exploredNodesBfs(15, binary.root)
        val expected = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)
        assertEquals(expected, result)
    }

    fun testBinaryTreeBfsWithNoNodes() {
        val binary = BinaryTree()
        val result = binary.exploredNodesBfs(15, binary.root)
        val expected = emptyList<Int>()
        assertEquals(expected, result)
    }

    fun testNaryTreeBfsWith3Children() {
        val nary = NaryTree()
        nary.loadTree(1)
        nary.loadTree(2)
        nary.loadTree(3)
        nary.loadTree(4)
        nary.loadTree(5)
        nary.loadTree(6)
        nary.loadTree(7)
        nary.loadTree(8)
        nary.loadTree(9)
        nary.loadTree(10)
        nary.loadTree(11)
        nary.loadTree(12)
        nary.loadTree(13)
        val result = nary.exploredNodesBfs(13, nary.root)
        val expected = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13)
        assertEquals(expected, result)
    }

    fun testNaryTreeBfsWith4Children() {
        NaryTree.n = 4
        val nary = NaryTree()
        nary.loadTree(1)
        nary.loadTree(2)
        nary.loadTree(3)
        nary.loadTree(4)
        nary.loadTree(5)
        nary.loadTree(6)
        nary.loadTree(7)
        nary.loadTree(8)
        nary.loadTree(9)
        nary.loadTree(10)
        nary.loadTree(11)
        nary.loadTree(12)
        nary.loadTree(13)
        nary.loadTree(14)
        nary.loadTree(15)
        nary.loadTree(16)
        nary.loadTree(17)
        nary.loadTree(18)
        nary.loadTree(19)
        nary.loadTree(20)
        nary.loadTree(21)
        val result = nary.exploredNodesBfs(21, nary.root)
        val expected = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21)
        assertEquals(expected, result)
    }

    fun testNaryTreeBfsWith5Children() {
        NaryTree.n = 5
        val nary = NaryTree()
        nary.loadTree(1)
        nary.loadTree(2)
        nary.loadTree(3)
        nary.loadTree(4)
        nary.loadTree(5)
        nary.loadTree(6)
        val result = nary.exploredNodesBfs(6, nary.root)
        val expected = listOf(1,2,3,4,5,6)
        assertEquals(expected, result)
    }

    fun testBinarySearchTreeBinarySearch() {
        val bst = BinarySearchTree()
       bst.loadTree(5)
       bst.loadTree(3)
       bst.loadTree(8)
       bst.loadTree(2)
       bst.loadTree(4)
       bst.loadTree(7)
       bst.loadTree(10)
       bst.loadTree(1)
       bst.loadTree(6)
       bst.loadTree(9)
       bst.loadTree(11)
        val result = bst.exploredNodesBinarySearch(6, bst.root)
        val expected = listOf(5,8,7,6)
        assertEquals(expected, result)
    }

    fun testBinarySearchTreeBinarySearchNoNodes() {
        val bst = BinarySearchTree()
        val result = bst.exploredNodesBinarySearch(6, bst.root)
        val expected = emptyList<Int>()
        assertEquals(expected, result)
    }

    fun testAVLTreeBinarySearch() {
        val avl = AVLTree()
        avl.loadTree(1)
        avl.loadTree(2)
        avl.loadTree(3)
        avl.loadTree(4)
        avl.loadTree(5)
        avl.loadTree(6)
        avl.loadTree(7)
        avl.loadTree(8)
        avl.loadTree(9)
        val result = avl.exploredNodesBinarySearch(7, avl.root)
        val expected = listOf(4,6,8,7)
        assertEquals(expected, result)
    }

    fun testAVLTreeBinarySearchNoNodes() {
        val avl = AVLTree()
        val result = avl.exploredNodesBinarySearch(6, avl.root)
        val expected = emptyList<Int>()
        assertEquals(expected, result)
    }
}