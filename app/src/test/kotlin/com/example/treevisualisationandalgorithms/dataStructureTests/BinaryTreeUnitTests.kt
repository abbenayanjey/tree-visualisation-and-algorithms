package com.example.treevisualisationandalgorithms.dataStructureTests
import com.example.treevisualisationandalgorithms.datastructures.BinaryTree

import junit.framework.TestCase


class BinaryTreeUnitTests: TestCase() {


    fun testBinaryLoadTree() {
        val binaryTree = BinaryTree()
        binaryTree.loadTree(5)
        binaryTree.loadTree(10)
        binaryTree.loadTree(15)
        val expected = listOf(5,10,15)
        val result = binaryTree.treeKeysBFS
        assertEquals(expected, result)
    }

    fun testBinaryInsertNodeRoot() {
        val binaryTree = BinaryTree()
        binaryTree.insertNode(5)
        val expected = listOf(5)
        val result = binaryTree.treeKeysBFS
        assertEquals(expected, result)
    }

    fun testBinaryExploredNodesInsertNoRoot() {
        val binaryTree = BinaryTree()
        val result = binaryTree.exploredNodesInsert(4)
        val expected = emptyList<Int>()
        assertEquals(expected,result)
    }

    fun testBinaryExploredNodesInsertWhereParentHasNoChild() {
        val binaryTree = BinaryTree()
       binaryTree.loadTree(1)
       binaryTree.loadTree(2)
       binaryTree.loadTree(3)
        val result = binaryTree.exploredNodesInsert(4)
        val expected = listOf(1,2)
        assertEquals(expected,result)
    }

    fun testBinaryExploredNodesInsertWhereParentHasOneChild() {
        val binaryTree = BinaryTree()
        binaryTree.loadTree(1)
        binaryTree.loadTree(2)
        binaryTree.loadTree(3)
        binaryTree.loadTree(4)
        val result = binaryTree.exploredNodesInsert(5)
        val expected = listOf(1,2)
        assertEquals(expected,result)
    }


    fun testBinaryReloadCase1() {
        val binaryTree = BinaryTree()
        binaryTree.loadTree(5)
        binaryTree.loadTree(10)
        binaryTree.reloadTree(10)
        val expected = listOf(5)
        val result = binaryTree.treeKeysBFS
        assertEquals(expected, result)
    }

    fun testBinaryReloadCase2() {
        val binaryTree = BinaryTree()
        binaryTree.loadTree(5)
        binaryTree.loadTree(10)
        binaryTree.loadTree(15)
        binaryTree.loadTree(20)
        binaryTree.loadTree(25)
        binaryTree.reloadTree(25)
        val expected = listOf(5,10,15,20)
        val result = binaryTree.treeKeysBFS
        assertEquals(expected, result)
    }

    fun testBinaryDeleteNonExistentRoot(){
        val binaryTree = BinaryTree()
        binaryTree.deleteNode(10)
        val result = binaryTree.treeKeysBFS
        val expected = null
        assertEquals(expected,result)
    }

    fun testBinaryExploredNodesDeleteLeftChild() {
        val binaryTree = BinaryTree()
       binaryTree.loadTree(1)
       binaryTree.loadTree(2)
       binaryTree.loadTree(3)
       binaryTree.loadTree(4)
        val result = binaryTree.exploredNodesDelete(4)
        val expected = listOf(1,2)
        assertEquals(expected,result)
    }
    fun testBinaryExploredNodesDeleteRightChild() {
        val binaryTree = BinaryTree()
        binaryTree.loadTree(1)
        binaryTree.loadTree(2)
        binaryTree.loadTree(3)
        binaryTree.loadTree(4)
        binaryTree.loadTree(5)
        val result = binaryTree.exploredNodesDelete(5)
        val expected = listOf(1,2)
        assertEquals(expected,result)
    }

    fun testBinaryExploredNodesDeleteEmptyTree() {
        val binaryTree = BinaryTree()
        val result = binaryTree.exploredNodesDelete(4)
        val expected = emptyList<Int>()
        assertEquals(expected,result)
    }

    fun testBinaryExploredNodesDeleteRoot() {
        val binaryTree = BinaryTree()
        binaryTree.loadTree(1)
        val result = binaryTree.exploredNodesDelete(1)
        val expected = listOf(1)
        assertEquals(expected,result)
    }

    fun testBinaryExploredNodesDeleteWhereKeyDoesNotExist() {
        val binaryTree = BinaryTree()
        binaryTree.loadTree(1)
        binaryTree.loadTree(2)
        binaryTree.loadTree(3)
        val result = binaryTree.exploredNodesDelete(4)
        val expected = listOf(1,2,3)
        assertEquals(expected,result)
    }



}