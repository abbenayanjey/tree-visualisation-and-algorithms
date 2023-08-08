package com.example.treevisualisationandalgorithms.visualiserTests
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.treevisualisationandalgorithms.MainActivity
import com.example.treevisualisationandalgorithms.R
import com.example.treevisualisationandalgorithms.screens.Visualiser
import com.example.treevisualisationandalgorithms.renderOperations.VisualiseActionController
import com.example.treevisualisationandalgorithms.serialise.LoadTree
import junit.framework.TestCase.assertEquals
import org.hamcrest.CoreMatchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NaryTreeVisualiserTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
    val seekBar = onView(withId(R.id.seekbar))


    @Test
    fun testNaryTreeInsert() {
        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("1"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("2"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("3"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("4"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("5"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("6"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("7"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        onView(withId(R.id.nextButton)).perform(click())
        onView(withId(R.id.nextButton)).perform(click())
        onView(withId(R.id.previousButton)).perform(click())
        onView(withId(R.id.previousButton)).perform(click())
        onView(withId(R.id.playButton)).perform(click())

        val result = Visualiser.tree?.treeKeysBFS
        val expected = listOf(1, 2, 3, 4, 5, 6, 7)
        assertEquals(expected, result)
    }

    @Test
    fun testNaryTreeLoad3Children() {
        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.number3)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("3-ary Tree Example")).perform(click())

        val result = Visualiser.tree?.treeKeysBFS
        val expected = (1..13).toList()
        assertEquals(expected, result)
    }

    @Test
    fun testNaryTreeLoad4Children() {
        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.number4)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("4-ary Tree Example")).perform(click())

        val result = Visualiser.tree?.treeKeysBFS
        val expected = (1..21).toList()
        assertEquals(expected, result)
    }

    @Test
    fun testNaryTreeLoad5Children() {
        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.number5)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("5-ary Tree Example")).perform(click())

        val result = Visualiser.tree?.treeKeysBFS
        val expected = (1..31).toList()
        assertEquals(expected, result)
    }


    @Test
    fun testNaryTreeDelete() {
        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("3-ary Tree Example")).perform(click())
        onView(withId(R.id.deleteButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("13"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())

        val result = Visualiser.tree?.treeKeysBFS
        val expected = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
        assertEquals(expected, result)
    }

    @Test
    fun testNaryTreeSearch() {

        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("3-ary Tree Example")).perform(click())
        onView(withId(R.id.searchButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("7"), closeSoftKeyboard())
        onView(withId(R.id.button_search)).perform(click())

        val result = Visualiser.tree?.treeKeysBFS
        val expected = (1..13).toList()
        assertEquals(expected, result)
    }

    @Test
    fun testNaryTreePreOrderFor3Children() {

        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.number3)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("3-ary Tree Example")).perform(click())
        onView(withId(R.id.preorderButton)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        Thread.sleep(1000)

        val result = Visualiser.tree?.getTraversalNodesDisplayed()
        val expected = listOf(1, 2, 5, 6 ,7 ,3, 8, 9, 10, 4, 11, 12, 13)
        assertEquals(expected, result)
    }

    @Test
    fun testNaryTreeInOrderFor3Children() {

        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.number3)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("3-ary Tree Example")).perform(click())
        onView(withId(R.id.inorderButton)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        Thread.sleep(1000)

        val result = Visualiser.tree?.getTraversalNodesDisplayed()
        val expected = listOf(5, 2, 6, 7, 1, 8, 3, 9, 10, 11, 4, 12, 13)
        assertEquals(expected, result)
    }

    @Test
    fun testNaryTreePostOrderFor3Children() {

        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.number3)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("3-ary Tree Example")).perform(click())
        onView(withId(R.id.postorderButton)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        Thread.sleep(1000)

        val result = Visualiser.tree?.getTraversalNodesDisplayed()
        val expected = listOf(5, 6 ,7 , 2, 8, 9, 10, 3, 11, 12, 13, 4, 1)
        assertEquals(expected, result)
    }

    @Test
    fun testNaryTreePreOrderFor4Children() {

        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.number4)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("4-ary Tree Example")).perform(click())
        onView(withId(R.id.preorderButton)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        Thread.sleep(1000)

        val result = Visualiser.tree?.getTraversalNodesDisplayed()
        val expected = listOf(1,2,6,7,8,9,3,10,11,12,13,4,14,15,16,17,5,18,19,20,21)
        assertEquals(expected, result)
    }

    @Test
    fun testNaryTreeInOrderFor4Children() {

        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.number4)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("4-ary Tree Example")).perform(click())
        onView(withId(R.id.inorderButton)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        Thread.sleep(1000)

        val result = Visualiser.tree?.getTraversalNodesDisplayed()
        val expected = listOf(6,7,2,8,9,10,11,3,12,13,1,14,15,4,16,17,18,19,5,20,21)
        assertEquals(expected, result)
    }

    @Test
    fun testNaryTreePostOrderFor4Children() {

        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.number4)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("4-ary Tree Example")).perform(click())
        onView(withId(R.id.postorderButton)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        Thread.sleep(1000)

        val result = Visualiser.tree?.getTraversalNodesDisplayed()
        val expected = listOf(6,7,8,9,2,10,11,12,13,3,14,15,16,17,4,18,19,20,21,5,1)
        assertEquals(expected, result)
    }

    @Test
    fun testNaryTreePreOrderFor5Children() {

        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.number5)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("5-ary Tree Example")).perform(click())
        onView(withId(R.id.preorderButton)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        Thread.sleep(1000)

        val result = Visualiser.tree?.getTraversalNodesDisplayed()
        val expected = listOf(1, 2, 7, 8, 9, 10, 11, 3, 12, 13, 14, 15, 16, 4, 17, 18, 19, 20, 21, 5, 22, 23, 24, 25, 26, 6, 27, 28, 29, 30, 31)
        assertEquals(expected, result)
    }

    @Test
    fun testNaryTreeInOrderFor5Children() {

        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.number5)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("5-ary Tree Example")).perform(click())
        onView(withId(R.id.inorderButton)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        Thread.sleep(1000)

        val result = Visualiser.tree?.getTraversalNodesDisplayed()
        val expected = listOf(7, 8, 2, 9, 10, 11, 12, 13, 3, 14, 15, 16, 1, 17, 18, 4, 19, 20, 21, 22, 23, 5, 24, 25, 26, 27, 28, 6, 29, 30, 31)
        assertEquals(expected, result)
    }

    @Test
    fun testNaryTreePostOrderFor5Children() {

        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.number5)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("5-ary Tree Example")).perform(click())
        onView(withId(R.id.postorderButton)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        Thread.sleep(1000)

        val result = Visualiser.tree?.getTraversalNodesDisplayed()
        val expected = listOf(7, 8, 9, 10, 11, 2, 12, 13, 14, 15, 16, 3, 17, 18, 19, 20, 21, 4, 22, 23, 24, 25, 26, 5, 27, 28, 29, 30, 31, 6, 1)
        assertEquals(expected, result)
    }




    @Test
    fun testNaryTreeMovementButtons() {

        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("3-ary Tree Example")).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.endButton)).perform(click())
        onView(withId(R.id.endButton)).perform(click())
        onView(withId(R.id.endButton)).perform(click())
        seekBar.perform(swipeLeft())
        seekBar.perform(swipeRight())

        val result = Visualiser.tree?.treeKeysBFS
        val expected = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)
        assertEquals(expected, result)

    }

    @Test
    fun testNaryTreeNextPreviousButtons() {

        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("3-ary Tree Example")).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("14"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        onView(withId(R.id.nextButton)).perform(click())
        onView(withId(R.id.nextButton)).perform(click())
        onView(withId(R.id.nextButton)).perform(click())
        onView(withId(R.id.nextButton)).perform(click())
        onView(withId(R.id.nextButton)).perform(click())
        onView(withId(R.id.previousButton)).perform(click())
        onView(withId(R.id.previousButton)).perform(click())
        onView(withId(R.id.previousButton)).perform(click())
        onView(withId(R.id.previousButton)).perform(click())
        onView(withId(R.id.previousButton)).perform(click())


        val result = VisualiseActionController.action
        val expected = 0
        assertEquals(expected, result)

    }

    @Test
    fun testNaryTreeSave() {

        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.back_button)).perform(click())
        onView(withId(R.id.naryButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("1"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("2"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("3"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("4"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("5"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("6"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("7"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.button_save)).perform(click())
        onView(withId(R.id.cancelSaveTreeButton)).perform(click())
        onView(withId(R.id.button_save)).perform(click())
        onView(withId(R.id.setTreeNameField)).perform(typeText("Instrumented Test 3-ary Tree"), closeSoftKeyboard())
        onView(withId(R.id.confirmSaveTreeButton)).perform(click())
        onView(withId(R.id.button_delete_all)).perform(scrollTo())
        onView(withId(R.id.button_delete_all)).perform(click())
        onView(withId(R.id.visualiserButton)).perform(scrollTo())
        onView(withId(R.id.visualiserButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.visualiserButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        val result = "Instrumented Test 3-ary Tree"
        val expected = LoadTree.loadTreeView.getItem(0).treeName

        assertEquals(expected, result)
    }




}




