package com.example.treevisualisationandalgorithms.nodeControl


abstract class Step {

    open fun perform() {
    }

    abstract fun performStepBackwards()
}