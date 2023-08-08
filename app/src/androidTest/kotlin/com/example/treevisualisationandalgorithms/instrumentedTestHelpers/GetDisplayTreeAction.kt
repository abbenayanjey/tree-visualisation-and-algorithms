package com.example.treevisualisationandalgorithms.instrumentedTestHelpers

import android.os.SystemClock
import android.view.MotionEvent
import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import com.example.treevisualisationandalgorithms.renderTree.DisplayTree
import org.hamcrest.Matcher

class PerformTouchEventAction(private val x: Float, private val y: Float) : ViewAction {
    override fun getConstraints(): Matcher<View> {
        return isAssignableFrom(DisplayTree::class.java)
    }

    override fun getDescription(): String {
        return "Perform touch event at coordinates ($x, $y)"
    }

    override fun perform(uiController: UiController, view: View) {
        val displayTree = view as DisplayTree
        val downTime = SystemClock.uptimeMillis()
        val eventTime = SystemClock.uptimeMillis()
        val metaState = 0

        val downEvent = MotionEvent.obtain(
            downTime, eventTime, MotionEvent.ACTION_DOWN,
            x, y, metaState
        )
        displayTree.dispatchTouchEvent(downEvent)

        val upEvent = MotionEvent.obtain(
            downTime, eventTime, MotionEvent.ACTION_UP,
            x, y, metaState
        )
        displayTree.dispatchTouchEvent(upEvent)

        downEvent.recycle()
        upEvent.recycle()
    }
}