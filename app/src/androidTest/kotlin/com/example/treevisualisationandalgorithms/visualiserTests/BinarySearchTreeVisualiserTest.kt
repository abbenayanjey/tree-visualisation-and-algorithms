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
class BinarySearchTreeVisualiserTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
    val seekBar = onView(withId(R.id.seekbar))


    @Test
    fun testBinarySearchTreeInsert() {
        onView(withId(R.id.bstButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("5"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("2"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("8"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("1"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("3"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("7"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("10"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        onView(withId(R.id.nextButton)).perform(click())
        onView(withId(R.id.nextButton)).perform(click())
        onView(withId(R.id.previousButton)).perform(click())
        onView(withId(R.id.previousButton)).perform(click())
        onView(withId(R.id.playButton)).perform(click())

        val result = Visualiser.tree?.treeKeysBFS
        val expected = listOf(5, 2, 8, 1, 3, 7, 10)
        assertEquals(expected, result)
    }




    @Test
    fun testBinarySearchTreeDelete() {
        onView(withId(R.id.bstButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("Binary Search Tree Example")).perform(click())
        onView(withId(R.id.deleteButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("11"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())

        val result = Visualiser.tree?.treeKeysBFS
        val expected = listOf(10, 5, 15, 3, 8, 12, 20, 1, 4, 7, 9, 14, 18, 25)
        assertEquals(expected, result)
    }

    @Test
    fun testBinarySearchTreeDelete2() {
        onView(withId(R.id.bstButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("Binary Search Tree Example")).perform(click())
        onView(withId(R.id.deleteButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("1"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("4"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("3"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("5"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("8"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("9"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("10"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("25"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("15"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.endButton)).perform(click())
        onView(withId(R.id.endButton)).perform(click())
        onView(withId(R.id.endButton)).perform(click())


        val result = Visualiser.tree?.treeKeysBFS
        val expected = listOf(11, 7, 18, 12, 20, 14)
        assertEquals(expected, result)
    }

    @Test
    fun testBinarySearchTreeSearch() {

        onView(withId(R.id.bstButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("Binary Search Tree Example")).perform(click())
        onView(withId(R.id.searchButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("7"), closeSoftKeyboard())
        onView(withId(R.id.button_search)).perform(click())

        val result = Visualiser.tree?.treeKeysBFS
        val expected = listOf(10, 5, 15, 3, 8, 12, 20, 1, 4, 7, 9, 11, 14, 18, 25)
        assertEquals(expected, result)
    }

    @Test
    fun testBinarySearchTreePreOrder() {

        onView(withId(R.id.bstButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("Binary Search Tree Example")).perform(click())
        onView(withId(R.id.preorderButton)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        Thread.sleep(1000)

        val result = Visualiser.tree?.getTraversalNodesDisplayed()
        val expected = listOf(10, 5, 3, 1, 4, 8, 7, 9, 15, 12, 11, 14, 20, 18, 25)
        assertEquals(expected, result)
    }

    @Test
    fun testBinarySearchTreeInOrder() {

        onView(withId(R.id.bstButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("Binary Search Tree Example")).perform(click())
        onView(withId(R.id.inorderButton)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        Thread.sleep(1000)

        val result = Visualiser.tree?.getTraversalNodesDisplayed()
        val expected = listOf(1, 3, 4, 5, 7, 8, 9, 10, 11, 12, 14, 15, 18, 20, 25)
        assertEquals(expected, result)
    }

    @Test
    fun testBinarySearchTreePostOrder() {

        onView(withId(R.id.bstButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("Binary Search Tree Example")).perform(click())
        onView(withId(R.id.postorderButton)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        Thread.sleep(1000)

        val result = Visualiser.tree?.getTraversalNodesDisplayed()
        val expected = listOf(1, 4, 3, 7, 9, 8, 5, 11, 14, 12, 18, 25, 20, 15, 10)
        assertEquals(expected, result)
    }


    @Test
    fun testBinarySearchTreeMovementButtons() {

        onView(withId(R.id.bstButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("Binary Search Tree Example")).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.endButton)).perform(click())
        onView(withId(R.id.endButton)).perform(click())
        onView(withId(R.id.endButton)).perform(click())
        seekBar.perform(swipeLeft())
        seekBar.perform(swipeRight())

        val result = Visualiser.tree?.treeKeysBFS
        val expected = listOf(10, 5, 15, 3, 8, 12, 20, 1, 4, 7, 9, 11, 14, 18, 25)
        assertEquals(expected, result)

    }

    @Test
    fun testBinarySearchTreeNextPreviousButtons() {

        onView(withId(R.id.bstButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("Binary Search Tree Example")).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("27"), closeSoftKeyboard())
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
    fun testBinarySearchTreeSave() {

        onView(withId(R.id.bstButton)).perform(click())
        onView(withId(R.id.back_button)).perform(click())
        onView(withId(R.id.bstButton)).perform(click())
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
        onView(withId(R.id.pauseButton)).perform(click())
        onView(withId(R.id.button_save)).perform(click())
        onView(withId(R.id.cancelSaveTreeButton)).perform(click())
        onView(withId(R.id.button_save)).perform(click())
        onView(withId(R.id.setTreeNameField)).perform(typeText("Instrumented Test BST"), closeSoftKeyboard())
        onView(withId(R.id.confirmSaveTreeButton)).perform(click())
        onView(withId(R.id.button_delete_all)).perform(scrollTo())
        onView(withId(R.id.button_delete_all)).perform(click())
        onView(withId(R.id.visualiserButton)).perform(scrollTo())
        onView(withId(R.id.visualiserButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.visualiserButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        val result = "Instrumented Test BST"
        val expected = LoadTree.loadTreeView.getItem(0).treeName

        assertEquals(expected, result)

    }


    @Test
    fun testLinearListToBST() {

        onView(withId(R.id.listButton)).perform(click())
        onView(withId(R.id.back_button)).perform(click())
        onView(withId(R.id.listButton)).perform(click())
        onView(withId(R.id.input_list)).perform(typeText("37,28,79,12,30,42,89,26,85,98,93"), closeSoftKeyboard())
        onView(withId(R.id.button_list_insert)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        onView(withId(R.id.deleteButton)).perform(click())
        onView(withId(R.id.input_list)).perform(typeText("93"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())
        onView(withId(R.id.searchButton)).perform(click())
        onView(withId(R.id.input_list)).perform(typeText("37"), closeSoftKeyboard())
        onView(withId(R.id.button_search)).perform(click())
        onView(withId(R.id.playButton)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())

        val result = Visualiser.tree?.treeKeysBFS
        val expected = listOf(37,28,79,12,30,42,89,26,85,98)
        assertEquals(expected, result)
    }

}




