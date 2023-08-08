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
class BinarySearchTreeDIYTests {

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testBinarySearchTreeInsertDIY() {

        onView(withId(R.id.bstButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("Binary Search Tree Example")).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("28"), closeSoftKeyboard())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(486f, 73f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(722f, 150f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(837f, 306f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(888f, 486f))
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
    fun testBinarySearchTreeDeleteDIY() {

        onView(withId(R.id.bstButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("Binary Search Tree Example")).perform(click())
        onView(withId(R.id.deleteButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("8"), closeSoftKeyboard())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(480f,70f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(252f,153f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(364f,309f))
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
    fun testBinarySearchTreeSearchDIY() {

        onView(withId(R.id.bstButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("Binary Search Tree Example")).perform(click())
        onView(withId(R.id.searchButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("14"), closeSoftKeyboard())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(480f, 70f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(710f, 150f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(589f, 306f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(648f, 501f))
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
    fun testBinarySearchTreePreOrderDIY() {

        onView(withId(R.id.bstButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("Binary Search Tree Example")).perform(click())
        onView(withId(R.id.preorderButton)).perform(click())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(480f, 73f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(249f, 155f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(134f, 318f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(72f, 498f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(184f, 498f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(364f, 318f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(305f, 504f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(423f, 504f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(716f, 161f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(601f, 315f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(557f, 492f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(657f, 501f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(828f, 312f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(784f, 489f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(879f, 504f))
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

        onView(withId(R.id.bstButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("Binary Search Tree Example")).perform(click())
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

        onView(withId(R.id.bstButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("Binary Search Tree Example")).perform(click())
        onView(withId(R.id.postorderButton)).perform(click())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(78f, 492f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(202f, 498f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(128f, 321f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(317f, 501f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(435f, 498f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(356f, 336f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(240f, 153f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(545f, 495f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(663f, 498f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(601f, 333f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(778f, 507f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(888f, 498f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(846f, 321f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(719f, 153f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(477f, 67f))
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

        onView(withId(R.id.bstButton)).perform(click())
        onView(withId(R.id.back_button)).perform(click())
        onView(withId(R.id.bstButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.visualiserButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        val seekBar = onView(withId(R.id.seekbar))
        seekBar.perform(swipeRight())
        seekBar.perform(swipeLeft())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("Binary Search Tree Example")).perform(click())
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




