package com.example.treevisualisationandalgorithms.renderOperations

import android.graphics.Canvas
import com.example.treevisualisationandalgorithms.MainActivity
import com.example.treevisualisationandalgorithms.nodeControl.Step
import com.example.treevisualisationandalgorithms.nodeControl.StepControls

abstract class VisualiseActionController {

    fun execute() {

        resume()

        var action = 0
        while (action < stepHistory.indices.count() && !StepControls.pauseStep) {
            stepHistory[action].perform()
            action++
        }

        drawNodesWithEdges()

        pause()
    }

    fun start() {
        StepControls.initiateStep()
        drawNodesWithEdges()
        action = 0
        progressAction = true
        stepHistory.clear()
    }

    protected fun attemptStart(): Boolean {

        if (StepControls.attemptInitiateStep()) return true

        action = 0
        progressAction = true
        stepHistory.clear()

        return true
    }

    fun end() {
        StepControls.endStep()
    }

    fun pause() {
        StepControls.pause()
    }


    fun resume() {
        StepControls.resume()
    }


    fun stepForward() {


        StepControls.pauseStep.takeIf { it }?.let {


            StepControls.attemptInitiateStep().takeIf { it }?.let {


                progressAction.takeUnless { it }?.let {
                    ++action
                    progressAction = true
                }

                when {

                    action >= stepHistory.size -> {
                        drawNodesWithEdges()
                        action = stepHistory.size
                        progressAction = false
                    }

                    else -> {
                        stepHistory[action].perform()
                        ++action
                    }
                }

                StepControls.endStep()
            }
        }
    }

    fun stepBackwards() {


        StepControls.pauseStep.takeIf { it }?.let {

            StepControls.attemptInitiateStep().takeIf { it }?.let {

                --action

                progressAction.takeIf { it }?.let {
                    --action
                    progressAction = false
                }

                when {
                    action < 0 -> {
                        action = 0
                        progressAction = true
                    }
                    else -> stepHistory[action].performStepBackwards()
                }

                StepControls.endStep()
            }
        }
    }

    protected abstract fun drawNodesWithEdges()

    open fun draw(canvas: Canvas?) {
        if (MainActivity.screen != null) MainActivity.screen?.display()
    }

    fun draw() {
        draw(MainActivity.getCanvas())
    }


    companion object {

        @JvmStatic
        protected var stepHistory = ArrayList<Step>()

        var action = 0

        private var progressAction = true
    }
}
