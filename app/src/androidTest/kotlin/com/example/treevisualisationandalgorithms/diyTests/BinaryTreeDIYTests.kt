package com.example.treevisualisationandalgorithms.diyTests
import android.graphics.Color
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.treevisualisationandalgorithms.*
import com.example.treevisualisationandalgorithms.MainActivity
import com.example.treevisualisationandalgorithms.instrumentedTestHelpers.PerformTouchEventAction
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.hamcrest.CoreMatchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BinaryTreeDIYTests {

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testBinaryTreeInsertDIY() {

        onView(withId(R.id.binaryButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("Binary Tree Example")).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("16"), closeSoftKeyboard())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(506f, 67f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(491f, 82f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(249f, 170f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(710f, 158f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(122f, 303f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(376f, 312f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(592f, 324f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(814f, 327f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(72f, 510f))
        onView(withId(R.id.checkButton)).perform(scrollTo())
        onView(withId(R.id.checkButton)).perform(click())
        activityRule.scenario.onActivity { activity ->
            val testNodesText = activity.findViewById<TextView>(R.id.testNodes).currentTextColor
            if (testNodesText == Color.GREEN) {
                assertTrue(true)
            } else assertFalse(true)
        }
    }

    @Test
    fun testBinaryTreeDeleteDIY() {

        onView(withId(R.id.binaryButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("Binary Tree Example")).perform(click())
        onView(withId(R.id.deleteButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("15"), closeSoftKeyboard())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(506f, 67f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(491f, 82f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(249f, 170f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(710f, 158f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(122f, 303f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(376f, 312f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(592f, 324f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(814f, 327f))
        onView(withId(R.id.checkButton)).perform(scrollTo())
        onView(withId(R.id.checkButton)).perform(click())
        activityRule.scenario.onActivity { activity ->
            val testNodesText = activity.findViewById<TextView>(R.id.testNodes).currentTextColor
            if (testNodesText == Color.GREEN) {
                assertTrue(true)
            } else assertFalse(true)
        }

    }

    @Test
    fun testBinaryTreeSearchDIY() {

        onView(withId(R.id.binaryButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("Binary Tree Example")).perform(click())
        onView(withId(R.id.searchButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("7"), closeSoftKeyboard())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(506f, 67f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(491f, 82f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(249f, 170f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(710f, 158f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(122f, 303f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(376f, 312f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(592f, 324f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(814f, 327f))
        onView(withId(R.id.checkButton)).perform(scrollTo())
        onView(withId(R.id.checkButton)).perform(click())
        activityRule.scenario.onActivity { activity ->
            val testNodesText = activity.findViewById<TextView>(R.id.testNodes).currentTextColor
            if (testNodesText == Color.GREEN) {
                assertTrue(true)
            } else assertFalse(true)
        }

    }
    @Test
    fun testBinaryTreePreOrderDIY() {

        onView(withId(R.id.binaryButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("Binary Tree Example")).perform(click())
        onView(withId(R.id.preorderButton)).perform(click())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(480f, 80f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(267f, 147f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(143f, 318f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(75f, 483f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(193f, 498f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(364f, 324f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(296f, 516f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(400f, 495f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(716f, 182f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(607f, 303f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(557f, 469f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(645f, 489f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(823f, 342f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(769f, 501f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(908f, 507f))
        onView(withId(R.id.checkButton)).perform(scrollTo())
        onView(withId(R.id.checkButton)).perform(click())
        activityRule.scenario.onActivity { activity ->
            val testNodesText = activity.findViewById<TextView>(R.id.testNodes).currentTextColor
            if (testNodesText == Color.GREEN) {
                assertTrue(true)
            } else assertFalse(true)
        }

    }

    @Test
    fun testBinaryTreeInOrderDIY() {

        onView(withId(R.id.binaryButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("Binary Tree Example")).perform(click())
        onView(withId(R.id.inorderButton)).perform(click())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(81f, 510f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(104f, 333f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(202f, 495f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(258f, 176f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(323f, 504f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(373f, 330f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(432f, 507f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(471f, 90f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(548f, 513f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(613f, 301f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(636f, 487f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(719f, 177f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(775f, 475f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(811f, 325f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(873f, 490f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(610f, 987f))
        onView(withId(R.id.checkButton)).perform(scrollTo())
        onView(withId(R.id.checkButton)).perform(click())
        activityRule.scenario.onActivity { activity ->
            val testNodesText = activity.findViewById<TextView>(R.id.testNodes).currentTextColor
            if (testNodesText == Color.GREEN) {
                assertTrue(true)
            } else assertFalse(true)
        }

    }

    @Test
    fun testBinaryTreePostOrderDIY() {

        onView(withId(R.id.binaryButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("Binary Tree Example")).perform(click())
        onView(withId(R.id.postorderButton)).perform(click())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(63f, 472f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(163f, 498f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(131f, 342f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(323f, 492f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(409f, 504f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(379f, 333f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(243f, 167f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(557f, 504f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(642f, 504f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(607f, 330f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(766f, 507f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(888f, 507f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(837f, 309f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(731f, 170f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(503f, 85f))
        onView(withId(R.id.checkButton)).perform(scrollTo())
        onView(withId(R.id.checkButton)).perform(click())
        activityRule.scenario.onActivity { activity ->
            val testNodesText = activity.findViewById<TextView>(R.id.testNodes).currentTextColor
            if (testNodesText == Color.GREEN) {
                assertTrue(true)
            } else assertFalse(true)
        }


    }

    @Test
    fun testBinaryTreeDIYMovementButtons() {

        onView(withId(R.id.binaryButton)).perform(click())
        onView(withId(R.id.back_button)).perform(click())
        onView(withId(R.id.binaryButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.visualiserButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        val seekBar = onView(withId(R.id.seekbar))
        seekBar.perform(swipeRight())
        seekBar.perform(swipeLeft())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("Binary Tree Example")).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.endButton)).perform(click())
        onView(withId(R.id.endButton)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        onView(withId(R.id.nextButton)).perform(click())
        onView(withId(R.id.previousButton)).perform(click())
        onView(withId(R.id.playButton)).perform(click())

    }

}




