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
class BinaryTreeVisualiserTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
    val seekBar = onView(withId(R.id.seekbar))


    @Test
    fun testBinaryTreeInsert() {
        onView(withId(R.id.binaryButton)).perform(click())
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
    fun testBinaryTreeDelete() {
        onView(withId(R.id.binaryButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("Binary Tree Example")).perform(click())
        onView(withId(R.id.deleteButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("13"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())

        val result = Visualiser.tree?.treeKeysBFS
        val expected = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15)
        assertEquals(expected, result)
    }

    @Test
    fun testBinaryTreeSearch() {

        onView(withId(R.id.binaryButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("Binary Tree Example")).perform(click())
        onView(withId(R.id.searchButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("7"), closeSoftKeyboard())
        onView(withId(R.id.button_search)).perform(click())

        val result = Visualiser.tree?.treeKeysBFS
        val expected = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
        assertEquals(expected, result)
    }

    @Test
    fun testBinaryTreePreOrder() {

        onView(withId(R.id.binaryButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("Binary Tree Example")).perform(click())
        onView(withId(R.id.preorderButton)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        Thread.sleep(1000)

        val result = Visualiser.tree?.getTraversalNodesDisplayed()
        val expected = listOf(1, 2, 4, 8, 9, 5, 10, 11, 3, 6, 12, 13, 7, 14, 15)
        assertEquals(expected, result)
    }

    @Test
    fun testBinaryTreeInOrder() {

        onView(withId(R.id.binaryButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("Binary Tree Example")).perform(click())
        onView(withId(R.id.inorderButton)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        Thread.sleep(1000)

        val result = Visualiser.tree?.getTraversalNodesDisplayed()
        val expected = listOf(8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 13, 3, 14, 7, 15)
        assertEquals(expected, result)
    }

    @Test
    fun testBinaryTreePostOrder() {

        onView(withId(R.id.binaryButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("Binary Tree Example")).perform(click())
        onView(withId(R.id.postorderButton)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        Thread.sleep(1000)

        val result = Visualiser.tree?.getTraversalNodesDisplayed()
        val expected = listOf(8, 9, 4, 10, 11, 5, 2, 12, 13, 6, 14, 15, 7, 3, 1)
        assertEquals(expected, result)
    }


    @Test
    fun testBinaryTreeMovementButtons() {

        onView(withId(R.id.binaryButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("Binary Tree Example")).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.endButton)).perform(click())
        onView(withId(R.id.endButton)).perform(click())
        onView(withId(R.id.endButton)).perform(click())
        seekBar.perform(swipeLeft())
        seekBar.perform(swipeRight())

        val result = Visualiser.tree?.treeKeysBFS
        val expected = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
        assertEquals(expected, result)

    }

    @Test
    fun testBinaryTreeNextPreviousButtons() {

        onView(withId(R.id.binaryButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("Binary Tree Example")).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("16"), closeSoftKeyboard())
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
    fun testBinaryTreeSave() {

        onView(withId(R.id.binaryButton)).perform(click())
        onView(withId(R.id.back_button)).perform(click())
        onView(withId(R.id.binaryButton)).perform(click())
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
        onView(withId(R.id.setTreeNameField)).perform(typeText("Instrumented Test Binary Tree"), closeSoftKeyboard())
        onView(withId(R.id.confirmSaveTreeButton)).perform(click())
        onView(withId(R.id.button_delete_all)).perform(scrollTo())
        onView(withId(R.id.button_delete_all)).perform(click())
        onView(withId(R.id.visualiserButton)).perform(scrollTo())
        onView(withId(R.id.visualiserButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.visualiserButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        val result = "Instrumented Test Binary Tree"
        val expected = LoadTree.loadTreeView.getItem(0).treeName

        assertEquals(expected, result)
    }






}




