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
class NaryTreeDIYTests {

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testNaryTreeInsertDIY() {

        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.number3)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("3-ary Tree Example")).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("14"), closeSoftKeyboard())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(483f, 73f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(172f, 158f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(468f, 176f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(802f, 158f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(81f, 318f))
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
    fun testNaryTreeDeleteDIY() {

        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.number3)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("3-ary Tree Example")).perform(click())
        onView(withId(R.id.deleteButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("5"), closeSoftKeyboard())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(474f, 73f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(175f, 158f))
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
    fun testNaryTreeSearchDIY() {

        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.number3)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("3-ary Tree Example")).perform(click())
        onView(withId(R.id.searchButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("4"), closeSoftKeyboard())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(494f, 90f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(187f, 153f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(486f, 182f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(808f, 179f))
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
    fun testNaryTreePreOrderDIY() {

        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.number3)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("3-ary Tree Example")).perform(click())
        onView(withId(R.id.preorderButton)).perform(click())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(465f,  73f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(149f,  155f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(66f, 300f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(169f,  315f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(270f,  327f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(480f,  158f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(385f,  312f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(477f,  324f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(583f,  309f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(790f,  176f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(701f,  306f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(784f,  312f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(893f,  312f))
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
    fun testNaryTreeInOrderDIY() {

        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.number3)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("3-ary Tree Example")).perform(click())
        onView(withId(R.id.inorderButton)).perform(click())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(57f, 303f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(157f, 155f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(166f, 312f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(282f, 315f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(486f, 73f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(370f, 303f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(480f, 173f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(465f, 324f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(583f, 321f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(678f, 318f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(781f, 161f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(787f, 303f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(885f, 327f))
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
    fun testNaryTreePostOrderDIY() {

        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.number3)).perform(click())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("3-ary Tree Example")).perform(click())
        onView(withId(R.id.postorderButton)).perform(click())
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(72f, 312f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(160f, 318f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(273f, 318f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(157f, 164f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(361f, 324f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(459f, 327f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(574f, 318f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(483f, 170f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(678f, 321f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(799f, 312f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(891f, 321f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(796f, 167f))
        onView(withId(R.id.TreeDisplay)).perform(PerformTouchEventAction(483f, 73f))
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
    fun testNaryTreeDIYMovementButtons() {

        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.back_button)).perform(click())
        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.visualiserButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.number5)).perform(click())
        onView(withId(R.id.number4)).perform(click())
        onView(withId(R.id.number3)).perform(click())
        val seekBar = onView(withId(R.id.seekbar))
        seekBar.perform(swipeRight())
        seekBar.perform(swipeLeft())
        onView(withId(R.id.loadDiyButton)).perform(scrollTo())
        onView(withId(R.id.loadDiyButton)).perform(click())
        onView(withText("3-ary Tree Example")).perform(click())
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




