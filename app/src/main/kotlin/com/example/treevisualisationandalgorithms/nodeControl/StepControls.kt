package com.example.treevisualisationandalgorithms.nodeControl

import java.util.concurrent.Semaphore

object StepControls {

    var duration = 800
    const val frames = 40
    private val mutex = Semaphore(1)

    fun initiateStep() {
        try {
            pause()
            mutex.acquire()
        } catch (e: InterruptedException) {
            e.printStackTrace()
            mutex.release()
        }
    }


    fun attemptInitiateStep(): Boolean {
        return mutex.tryAcquire()
    }


    fun endStep() {
        mutex.release()
    }


    var pauseStep = false


    fun pause() {
        pauseStep = true
    }

    fun resume() {
        pauseStep = false
    }

    fun resetAllSteps() {
        pauseStep = false
        initiateStep()
        endStep()
    }

}