package com.example.treevisualisationandalgorithms.dataStructureTests

import com.example.treevisualisationandalgorithms.datastructures.AVLTree
import junit.framework.TestCase


class AVLTreeUnitTests: TestCase() {


    fun testAVLLoadTree() {
        val avlTree = AVLTree()
        avlTree.loadTree(5)
        avlTree.loadTree(10)
        avlTree.loadTree(15)
        val expected = listOf(10,5,15)
        val result = avlTree.treeKeysBFS
        assertEquals(expected, result)
    }

    fun testAVLReloadCase1() {
        val avlTree = AVLTree()
        avlTree.loadTree(5)
        avlTree.loadTree(10)
        avlTree.reloadTree(10)
        val expected = listOf(5)
        val result = avlTree.treeKeysBFS
        assertEquals(expected, result)
    }

    fun testAVLReloadCase2() {
        val avlTree = AVLTree()
        avlTree.loadTree(5)
        avlTree.loadTree(10)
        avlTree.reloadTree(5)
        val expected = listOf(10)
        val result = avlTree.treeKeysBFS
        assertEquals(expected, result)
    }

    fun testAVLReloadCase3() {
        val avlTree = AVLTree()
        avlTree.loadTree(1)
        avlTree.loadTree(2)
        avlTree.loadTree(3)
        avlTree.loadTree(4)
        avlTree.reloadTree(2)
        val expected = listOf(3,1,4)
        val result = avlTree.treeKeysBFS
        assertEquals(expected, result)
    }

    fun testAVLReloadCase4() {
        val avlTree = AVLTree()
        avlTree.loadTree(5)
        avlTree.loadTree(4)
        avlTree.loadTree(3)
        avlTree.loadTree(2)
        avlTree.reloadTree(4)
        val expected = listOf(3,2,5)
        val result = avlTree.treeKeysBFS
        assertEquals(expected, result)
    }


    fun testAVLReloadNonExistentKey() {
        val avlTree = AVLTree()
        avlTree.loadTree(1)
        avlTree.loadTree(2)
        avlTree.loadTree(3)
        avlTree.reloadTree(4)
        val result = avlTree.treeKeysBFS
        val expected = listOf(2,1,3)
        assertEquals(expected, result)
    }

    fun testAVLExploredNodesInsertNoRoot() {
        val avlTree = AVLTree()
        val result = avlTree.exploredNodesInsert(4)
        val expected = listOf(4)
        assertEquals(expected,result)
    }

    fun testAVLExploredNodesInsertWhereKeyIsGreater() {
        val avlTree = AVLTree()
        avlTree.loadTree(1)
        avlTree.loadTree(2)
        avlTree.loadTree(3)
        val result = avlTree.exploredNodesInsert(4)
        val expected = listOf(2,3)
        assertEquals(expected,result)
    }
    fun testAVLExploredNodesInsertWhereKeyIsSmaller() {
        val avlTree = AVLTree()
        avlTree.loadTree(1)
        avlTree.loadTree(2)
        avlTree.loadTree(4)
        val result = avlTree.exploredNodesInsert(3)
        val expected = listOf(2,4)
        assertEquals(expected,result)
    }



    fun testAVLRightRotation(){
        val avlTree = AVLTree()
        avlTree.loadTree(3)
        avlTree.loadTree(2)
        avlTree.loadTree(1)
        val result = avlTree.treeKeysBFS
        val expected = listOf(2,1,3)
        assertEquals(expected,result)
    }

    fun testAVLLeftRotation(){
        val avlTree = AVLTree()
        avlTree.loadTree(1)
        avlTree.loadTree(2)
        avlTree.loadTree(3)
        val result = avlTree.treeKeysBFS
        val expected = listOf(2,1,3)
        assertEquals(expected,result)
    }

    fun testAVLLeftRightRotation(){
        val avlTree = AVLTree()
        avlTree.loadTree(3)
        avlTree.loadTree(1)
        avlTree.loadTree(2)
        val result = avlTree.treeKeysBFS
        val expected = listOf(2,1,3)
        assertEquals(expected,result)
    }

    fun testAVLRightLeftRotation(){
        val avlTree = AVLTree()
        avlTree.loadTree(2)
        avlTree.loadTree(4)
        avlTree.loadTree(3)
        val result = avlTree.treeKeysBFS
        val expected = listOf(3,2,4)
        assertEquals(expected,result)
    }

    fun testAVLInsertRoot(){
        val avlTree = AVLTree()
        avlTree.insertNode(10)
        val result = avlTree.treeKeysBFS
        val expected = listOf(10)
        assertEquals(expected,result)
    }

    fun testAVLDeleteNonExistentRoot(){
        val avlTree = AVLTree()
        avlTree.deleteNode(10)
        val result = avlTree.treeKeysBFS
        val expected = null
        assertEquals(expected,result)
    }

    fun testAVLExploredNodesDelete() {
        val avlTree = AVLTree()
        avlTree.loadTree(1)
        avlTree.loadTree(2)
        avlTree.loadTree(3)
        avlTree.loadTree(4)
        val result = avlTree.exploredNodesDelete(4)
        val expected = listOf(2,3,4)
        assertEquals(expected,result)
    }

    fun testAVLExploredNodesDeleteWhereKeyIsGreater() {
        val avlTree = AVLTree()
        avlTree.loadTree(1)
        avlTree.loadTree(3)
        avlTree.loadTree(2)
        val result = avlTree.exploredNodesDelete(1)
        val expected = listOf(2,1)
        assertEquals(expected,result)
    }
    fun testAVLExploredNodesDeleteWhereKeyIsSmaller() {
        val avlTree = AVLTree()
        avlTree.loadTree(1)
        avlTree.loadTree(2)
        avlTree.loadTree(4)
        val result = avlTree.exploredNodesDelete(4)
        val expected = listOf(2,4)
        assertEquals(expected,result)
    }

    fun testAVLExploredNodesDeleteWhereKeyDoesNotExist() {
        val avlTree = AVLTree()
        avlTree.loadTree(1)
        avlTree.loadTree(2)
        avlTree.loadTree(4)
        val result = avlTree.exploredNodesDelete(5)
        val expected = listOf(2,4)
        assertEquals(expected,result)
    }
}