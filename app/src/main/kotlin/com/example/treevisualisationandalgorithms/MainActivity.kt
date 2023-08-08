package com.example.treevisualisationandalgorithms

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.treevisualisationandalgorithms.renderTree.DisplayTree
import com.example.treevisualisationandalgorithms.screens.Home


class MainActivity : AppCompatActivity() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        private lateinit var context: Context
        private lateinit var fragmentManagerVariable: FragmentManager
        var screen: DisplayTree? = null

        fun setContext(appContext: Context) {
            context = appContext
        }

        fun openFragment(fragment: Fragment) {
            val transaction = fragmentManagerVariable.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment, "visible_fragment")
            transaction.addToBackStack(null)
            transaction.commit()
        }

        fun setVisualizerCanvas(displayTree: DisplayTree?) {
            screen = displayTree
        }

        fun getCanvas(): Canvas {
            return screen?.canvas ?: Canvas(
                Bitmap.createBitmap(
                    100,
                    100,
                    Bitmap.Config.ARGB_8888
                )
            )
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManagerVariable = supportFragmentManager
        setContext(applicationContext)
        openFragment(Home())
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}