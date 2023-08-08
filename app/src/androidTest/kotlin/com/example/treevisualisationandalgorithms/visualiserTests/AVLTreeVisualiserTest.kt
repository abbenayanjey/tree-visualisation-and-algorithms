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
class AVLTreeVisualiserTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    val seekBar = onView(withId(R.id.seekbar))


    @Test
    fun testAVLTreeInsert() {
        onView(withId(R.id.avlButton)).perform(click())
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
        val expected = listOf(4,2,6,1,3,5,7)
        assertEquals(expected, result)
    }

    @Test
    fun testAVLTreeInsert2() {
        onView(withId(R.id.avlButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("5"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("8"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("4"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("2"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("3"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        Thread.sleep(8000)


        val result = Visualiser.tree?.treeKeysBFS
        val expected = listOf(5,3,8,2,4)
        assertEquals(expected, result)
    }





    @Test
    fun testAVLTreeDelete() {
        onView(withId(R.id.avlButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("AVL Tree Example")).perform(click())
        onView(withId(R.id.deleteButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("6"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())

        val result = Visualiser.tree?.treeKeysBFS
        val expected = listOf(4,2,7,1,3,5,8,9)
        assertEquals(expected, result)
    }

    @Test
    fun testAVLTreeDelete2() {
        onView(withId(R.id.avlButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("AVL Tree Example")).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("10"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("11"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("12"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("13"), closeSoftKeyboard())
        onView(withId(R.id.button_insert)).perform(click())
        onView(withId(R.id.deleteButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("1"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("2"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("4"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("6"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("8"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("12"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("10"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("13"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("11"), closeSoftKeyboard())
        onView(withId(R.id.button_delete)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.endButton)).perform(click())
        onView(withId(R.id.endButton)).perform(click())
        onView(withId(R.id.endButton)).perform(click())

        val result = Visualiser.tree?.treeKeysBFS
        val expected = listOf(9, 5, 12, 3, 7, 10, 13, 11)
        assertEquals(expected, result)
    }

    @Test
    fun testAVLTreeSearch() {

        onView(withId(R.id.avlButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("AVL Tree Example")).perform(click())
        onView(withId(R.id.searchButton)).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("7"), closeSoftKeyboard())
        onView(withId(R.id.button_search)).perform(click())

        val result = Visualiser.tree?.treeKeysBFS
        val expected = listOf(4, 2, 6, 1, 3, 5, 8, 7, 9)
        assertEquals(expected, result)
    }

    @Test
    fun testAVLTreePreOrder() {

        onView(withId(R.id.avlButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("AVL Tree Example")).perform(click())
        onView(withId(R.id.preorderButton)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        Thread.sleep(1000)

        val result = Visualiser.tree?.getTraversalNodesDisplayed()
        val expected = listOf(4,2,1,3,6,5,8,7,9)
        assertEquals(expected, result)
    }

    @Test
    fun testAVLTreeInOrder() {

        onView(withId(R.id.avlButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("AVL Tree Example")).perform(click())
        onView(withId(R.id.inorderButton)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        Thread.sleep(1000)

        val result = Visualiser.tree?.getTraversalNodesDisplayed()
        val expected = listOf(1,2,3,4,5,6,7,8,9)
        assertEquals(expected, result)
    }

    @Test
    fun testAVLTreePostOrder() {

        onView(withId(R.id.avlButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("AVL Tree Example")).perform(click())
        onView(withId(R.id.postorderButton)).perform(click())
        onView(withId(R.id.pauseButton)).perform(click())
        Thread.sleep(1000)

        val result = Visualiser.tree?.getTraversalNodesDisplayed()
        val expected = listOf(1,3,2,5,7,9,8,6,4)
        assertEquals(expected, result)
    }


    @Test
    fun testAVLTreeMovementButtons() {

        onView(withId(R.id.avlButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("AVL Tree Example")).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.restartButton)).perform(click())
        onView(withId(R.id.endButton)).perform(click())
        onView(withId(R.id.endButton)).perform(click())
        onView(withId(R.id.endButton)).perform(click())
        seekBar.perform(swipeLeft())
        seekBar.perform(swipeRight())

        val result = Visualiser.tree?.treeKeysBFS
        val expected = listOf(4, 2, 6, 1, 3, 5, 8, 7, 9)
        assertEquals(expected, result)

    }

    @Test
    fun testAVLTreeNextPreviousButtons() {

        onView(withId(R.id.avlButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        onView(withText("AVL Tree Example")).perform(click())
        onView(withId(R.id.input_nodes)).perform(typeText("10"), closeSoftKeyboard())
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
    fun testAVLTreeSave() {

        onView(withId(R.id.avlButton)).perform(click())
        onView(withId(R.id.back_button)).perform(click())
        onView(withId(R.id.avlButton)).perform(click())
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
        onView(withId(R.id.setTreeNameField)).perform(typeText("Instrumented Test AVL Tree"), closeSoftKeyboard())
        onView(withId(R.id.confirmSaveTreeButton)).perform(click())
        onView(withId(R.id.button_delete_all)).perform(scrollTo())
        onView(withId(R.id.button_delete_all)).perform(click())
        onView(withId(R.id.visualiserButton)).perform(scrollTo())
        onView(withId(R.id.visualiserButton)).perform(click())
        onView(withId(R.id.diyButton)).perform(click())
        onView(withId(R.id.visualiserButton)).perform(click())
        onView(withId(R.id.button_load)).perform(click())
        val result = "Instrumented Test AVL Tree"
        val expected = LoadTree.loadTreeView.getItem(0).treeName

        assertEquals(expected, result)
    }

}




