package com.example.treevisualisationandalgorithms.dataStructureTests

import com.example.treevisualisationandalgorithms.datastructures.BinarySearchTree
import junit.framework.TestCase


class BinarySearchTreeUnitTests: TestCase() {


    fun testBSTLoadTree() {
        val bst = BinarySearchTree()
        bst.loadTree(5)
        bst.loadTree(15)
        bst.loadTree(10)
        val expected = listOf(5,15,10)
        val result = bst.treeKeysBFS
        assertEquals(expected, result)
    }

    fun testBSTInsertNodeRoot() {
        val bst = BinarySearchTree()
        bst.insertNode(5)
        val expected = listOf(5)
        val result = bst.treeKeysBFS
        assertEquals(expected, result)
    }

    fun testBSTExploredNodesInsertNoRoot() {
        val bst = BinarySearchTree()
        val result = bst.exploredNodesInsert(4)
        val expected = listOf(4)
        assertEquals(expected,result)
    }

    fun testBSTExploredNodesInsertWhereKeyIsGreater() {
        val bst = BinarySearchTree()
        bst.loadTree(1)
        bst.loadTree(2)
        bst.loadTree(3)
        val result = bst.exploredNodesInsert(4)
        val expected = listOf(1,2,3)
        assertEquals(expected,result)
    }
    fun testBSTExploredNodesInsertWhereKeyIsSmaller() {
        val bst = BinarySearchTree()
        bst.loadTree(1)
        bst.loadTree(2)
        bst.loadTree(4)
        val result = bst.exploredNodesInsert(3)
        val expected = listOf(1,2,4)
        assertEquals(expected,result)
    }

    fun testBSTReloadCase1() {
        val bst = BinarySearchTree()
        bst.loadTree(5)
        bst.loadTree(10)
        bst.reloadTree(10)
        val expected = listOf(5)
        val result = bst.treeKeysBFS
        assertEquals(expected, result)
    }

    fun testBSTReloadCase2() {
        val bst = BinarySearchTree()
        bst.loadTree(5)
        bst.loadTree(10)
        bst.reloadTree(5)
        val expected = listOf(10)
        val result = bst.treeKeysBFS
        assertEquals(expected, result)
    }

    fun testBSTReloadCase3() {
        val bst = BinarySearchTree()
        bst.loadTree(1)
        bst.loadTree(2)
        bst.loadTree(3)
        bst.loadTree(4)
        bst.reloadTree(2)
        val expected = listOf(1,3,4)
        val result = bst.treeKeysBFS
        assertEquals(expected, result)
    }

    fun testBSTReloadCase4() {
        val bst = BinarySearchTree()
        bst.loadTree(5)
        bst.loadTree(4)
        bst.loadTree(3)
        bst.loadTree(2)
        bst.reloadTree(4)
        val expected = listOf(5,3,2)
        val result = bst.treeKeysBFS
        assertEquals(expected, result)
    }

    fun testBSTReloadCase5() {
        val bst = BinarySearchTree()
        bst.loadTree(1)
        bst.loadTree(3)
        bst.loadTree(2)
        bst.loadTree(4)
        bst.loadTree(5)
        bst.reloadTree(3)
        val expected = listOf(1,4,2,5)
        val result = bst.treeKeysBFS
        assertEquals(expected, result)
    }

    fun testBSTSuccessors() {
        val bst = BinarySearchTree()
        bst.loadTree(41)
        bst.loadTree(20)
        bst.loadTree(65)
        bst.loadTree(11)
        bst.loadTree(29)
        bst.loadTree(32)
        bst.loadTree(65)
        bst.loadTree(50)
        bst.loadTree(91)
        bst.loadTree(72)
        bst.loadTree(99)
        bst.reloadTree(65)
        bst.reloadTree(20)
        val expected = listOf(41,29,72,11,32,50,91,99)
        val result = bst.treeKeysBFS
        assertEquals(expected, result)
    }


    fun testBSTReloadNonExistentKey() {
        val bst = BinarySearchTree()
        bst.loadTree(1)
        bst.loadTree(2)
        bst.loadTree(3)
        bst.reloadTree(4)
        val result = bst.treeKeysBFS
        val expected = listOf(1,2,3)
        assertEquals(expected, result)
    }

    fun testBSTDeleteNonExistentRoot(){
        val bst = BinarySearchTree()
        bst.deleteNode(10)
        val result = bst.treeKeysBFS
        val expected = null
        assertEquals(expected,result)
    }

    fun testBSTExploredNodesDelete() {
        val bst = BinarySearchTree()
        bst.loadTree(1)
        bst.loadTree(2)
        bst.loadTree(3)
        bst.loadTree(4)
        val result = bst.exploredNodesDelete(4)
        val expected = listOf(1,2,3,4)
        assertEquals(expected,result)
    }

    fun testBSTLExploredNodesDeleteWhereKeyIsGreater() {
        val bst = BinarySearchTree()
        bst.loadTree(2)
        bst.loadTree(1)
        bst.loadTree(3)
        val result = bst.exploredNodesDelete(1)
        val expected = listOf(2,1)
        assertEquals(expected,result)
    }
    fun testBSTExploredNodesDeleteWhereKeyIsSmaller() {
        val bst = BinarySearchTree()
        bst.loadTree(2)
        bst.loadTree(1)
        bst.loadTree(4)
        val result = bst.exploredNodesDelete(4)
        val expected = listOf(2,4)
        assertEquals(expected,result)
    }

    fun testBSTExploredNodesDeleteWhereKeyDoesNotExist() {
        val bst = BinarySearchTree()
        bst.loadTree(2)
        bst.loadTree(1)
        bst.loadTree(4)
        val result = bst.exploredNodesDelete(5)
        val expected = listOf(2,4)
        assertEquals(expected,result)
    }



}