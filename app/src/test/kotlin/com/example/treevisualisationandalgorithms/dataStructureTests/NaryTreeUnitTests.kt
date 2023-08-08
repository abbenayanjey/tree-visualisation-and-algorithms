package com.example.treevisualisationandalgorithms.dataStructureTests


import com.example.treevisualisationandalgorithms.datastructures.NaryTree
import junit.framework.TestCase


class NaryTreeUnitTests: TestCase() {

    fun testDefaultNaryChildren() {
        val naryTree = NaryTree()
        naryTree.loadTree(1)
        naryTree.loadTree(2)
        naryTree.loadTree(3)
        assertEquals(3, naryTree.n)
    }

    fun testNaryChildrenSetTo4() {
        NaryTree.setNumChildrenProperty(4)
        assertEquals(4, NaryTree.n)
    }

    fun testNaryChildrenSetTo5() {
        NaryTree.setNumChildrenProperty(5)
        assertEquals(5, NaryTree.n)
    }

    fun testNaryLoadTree() {
        val naryTree = NaryTree()
        naryTree.loadTree(1)
        naryTree.loadTree(2)
        naryTree.loadTree(3)
        val expected = listOf(1,2,3)
        val result = naryTree.treeKeysBFS
        assertEquals(expected, result)
    }

    fun testNaryInsertNodeRoot() {
        val naryTree = NaryTree()
        naryTree.insertNode(5)
        val expected = listOf(5)
        val result = naryTree.treeKeysBFS
        assertEquals(expected, result)
    }

    fun testNaryExploredNodesInsertNoRoot() {
        val naryTree = NaryTree()
        val result = naryTree.exploredNodesInsert(4)
        val expected = emptyList<Int>()
        assertEquals(expected,result)
    }

    fun testNaryExploredNodesInsertWhereParentHasNoChild() {
        val naryTree = NaryTree()
        naryTree.loadTree(1)
        naryTree.loadTree(2)
        naryTree.loadTree(3)
        naryTree.loadTree(4)
        val result = naryTree.exploredNodesInsert(5)
        val expected = listOf(1,2)
        assertEquals(expected,result)
    }

    fun testNaryExploredNodesInsertWhereParentHasOneChild() {
        val naryTree = NaryTree()
        naryTree.loadTree(1)
        naryTree.loadTree(2)
        naryTree.loadTree(3)
        naryTree.loadTree(4)
        val result = naryTree.exploredNodesInsert(5)
        val expected = listOf(1,2)
        assertEquals(expected,result)
    }

    fun testNaryReloadCase1() {
        val naryTree = NaryTree()
        naryTree.loadTree(1)
        naryTree.loadTree(2)
        naryTree.loadTree(3)
        naryTree.loadTree(4)
        naryTree.reloadTree(4)
        val expected = listOf(1,2,3)
        val result = naryTree.treeKeysBFS
        assertEquals(expected, result)
    }

    fun testNaryReloadCase2() {
        val naryTree = NaryTree()
        naryTree.loadTree(1)
        naryTree.loadTree(2)
        naryTree.loadTree(3)
        naryTree.loadTree(4)
        naryTree.loadTree(5)
        naryTree.loadTree(6)
        naryTree.loadTree(7)
        naryTree.reloadTree(7)
        val expected = listOf(1,2,3,4,5,6)
        val result = naryTree.treeKeysBFS
        assertEquals(expected, result)
    }


    fun testNaryReloadCase3() {
        val naryTree = NaryTree()
        naryTree.loadTree(1)
        naryTree.reloadTree(2)
        val expected = listOf(1)
        val result = naryTree.treeKeysBFS
        assertEquals(expected, result)
    }

    fun testNaryDeleteNonExistentRoot(){
        val naryTree = NaryTree()
        naryTree.deleteNode(10)
        val result = naryTree.treeKeysBFS
        val expected = null
        assertEquals(expected,result)
    }

    fun testNaryExploredNodesDeleteFirstChild() {
        val naryTree = NaryTree()
        naryTree.loadTree(1)
        naryTree.loadTree(2)
        naryTree.loadTree(3)
        naryTree.loadTree(4)
        naryTree.loadTree(5)
        val result = naryTree.exploredNodesDelete(5)
        val expected = listOf(1)
        assertEquals(expected,result)
    }

    fun testBinaryExploredNodesDeleteMiddleChild() {
        val naryTree = NaryTree()
        naryTree.loadTree(1)
        naryTree.loadTree(2)
        naryTree.loadTree(3)
        naryTree.loadTree(4)
        naryTree.loadTree(5)
        naryTree.loadTree(6)
        val result = naryTree.exploredNodesDelete(6)
        val expected = listOf(1,2)
        assertEquals(expected,result)
    }

    fun testBinaryExploredNodesDeleteLastChild() {
        val naryTree = NaryTree()
        naryTree.loadTree(1)
        naryTree.loadTree(2)
        naryTree.loadTree(3)
        naryTree.loadTree(4)
        naryTree.loadTree(5)
        naryTree.loadTree(6)
        naryTree.loadTree(7)
        val result = naryTree.exploredNodesDelete(7)
        val expected = listOf(1,2)
        assertEquals(expected,result)
    }



    fun testBinaryExploredNodesDeleteEmptyTree() {
        val naryTree = NaryTree()
        val result = naryTree.exploredNodesDelete(4)
        val expected = emptyList<Int>()
        assertEquals(expected,result)
    }

    fun testBinaryExploredNodesDeleteRoot() {
        val naryTree = NaryTree()
        naryTree.loadTree(1)
        val result = naryTree.exploredNodesDelete(1)
        val expected = emptyList<Int>()
        assertEquals(expected,result)
    }


}