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
class AVLTreeDIYTests {

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testAVLTreeInsertDIY() {

        onView(withId(R.id.avlButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("AVL Tree Example")).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("28"), closeSoftKeyboard())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(483f, 76f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(713f, 155f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(826f, 318f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(888f, 507f))
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
    fun testAVLTreeDeleteDIY() {

        onView(withId(R.id.avlButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("AVL Tree Example")).perform(click())
        onView(withId(R.id.deleteButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("8"), closeSoftKeyboard())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(480f,79f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(722f,158f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(837f,315f))
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
    fun testAVLTreeSearchDIY() {

        onView(withId(R.id.avlButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("AVL Tree Example")).perform(click())
        onView(withId(R.id.searchButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("7"), closeSoftKeyboard())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(474f, 79f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(701f, 153f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(828f, 310f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(778f, 484f))
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
    fun testAVLTreePreOrderDIY() {

        onView(withId(R.id.avlButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("AVL Tree Example")).perform(click())
        onView(withId(R.id.preorderButton)).perform(click())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(480f,67f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(246f,153f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(137f,315f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(367f,321f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(725f,164f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(601f,315f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(837f,321f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(778f,492f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(891f,498f))
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
    fun testAVLTreeInOrderDIY() {

        onView(withId(R.id.avlButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("AVL Tree Example")).perform(click())
        onView(withId(R.id.inorderButton)).perform(click())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(128f,315f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(249f,164f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(373f,315f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(486f,79f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(598f,312f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(713f,164f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(775f,504f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(828f,309f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(896f,492f))
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
    fun testAVLTreePostOrderDIY() {

        onView(withId(R.id.avlButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("AVL Tree Example")).perform(click())
        onView(withId(R.id.postorderButton)).perform(click())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(131f, 312f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(358f, 324f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(240f, 158f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(601f, 318f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(769f, 498f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(891f, 495f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(834f, 312f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(719f, 164f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(491f, 82f))
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
    fun testAVLTreeDIYMovementButtons() {

        onView(withId(R.id.avlButton)).perform(click())
        onView(withId(R.id.back_button)).perform(click())
        onView(withId(R.id.avlButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.visualiserButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        val seekBar = onView(withId(R.id.seekbar))
        seekBar.perform(swipeRight())
        seekBar.perform(swipeLeft())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("AVL Tree Example")).perform(click())
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




