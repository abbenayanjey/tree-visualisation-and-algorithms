package com.example.treevisualisationandalgorithms.renderOperations

import com.example.treevisualisationandalgorithms.renderOperations.operations.InterfaceStepVariables
import com.example.treevisualisationandalgorithms.renderOperations.operations.Operations


abstract class ActionRecord : Operations() {

    private var actions = ArrayList<InterfaceStepVariables>()
    var actionIndex = 0
    private var editableAction = true


    fun deleteAllNodes() {
        start()
        resetActions()
        editableAction = false
        for (i in treeValues) reloadTree(i)
        editableAction = true
        end()
    }

    fun resetTree() {
        for (i in treeValues) reloadTree(i)
    }


    private inner class KeyAdd constructor(override var key: Int) : InterfaceStepVariables {

        override fun action() {
            loadTree(key)
        }
    }

    private inner class KeyRemove constructor(override var key: Int) : InterfaceStepVariables {

        override fun action() {
            reloadTree(key)
        }
    }

    private inner class RemoveAllKeys constructor(override var key: Int) : InterfaceStepVariables {

        override fun action() {
            resetTree()
        }
    }

    protected fun addAction(key: Int) {

        if (!editableAction) return

        while (actionIndex < actions.size) actions.removeAt(actionIndex)

        ++actionIndex
        actions.add(KeyAdd(key))
    }

    protected fun minusAction(key: Int) {

        if (!editableAction) return

        ++actionIndex
        actions.add(KeyRemove(key))
    }

    private fun resetActions() {

        if (!editableAction) return
        ++actionIndex
        actions.add(RemoveAllKeys(0))
    }

    fun repeatAction() {

        if (actionIndex < actions.size) {

            if (!attemptStart()) return
            editableAction = false
            resetTree()

            ++actionIndex
            for (i in 0 until actionIndex) actions[i].action()

            drawNodesWithEdges()
            editableAction = true
            end()
        }
    }

    fun revertAction() {

        if (!attemptStart()) return

        editableAction = false
        resetTree()

        actionIndex = (actionIndex - 1).coerceAtLeast(0)
        for (i in 0 until actionIndex) actions[i].action()

        drawNodesWithEdges()
        editableAction = true

        end()
    }


}