package com.example.treevisualisationandalgorithms.renderTree

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.SurfaceView
import com.example.treevisualisationandalgorithms.screens.DIY
import com.example.treevisualisationandalgorithms.screens.Visualiser

class DisplayTree(context: Context?, attributes: AttributeSet?) : SurfaceView(context, attributes) {

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs)

    var canvas: Canvas? = null
    private var visualiser: Visualiser? = null
    private var diy: DIY? = null
    private var surface: Bitmap? = null


    fun setSurfaceSize(vHeight: Int, vWidth: Int) {
        if (surface == null) {
            surface = Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888)
            canvas = Canvas(surface!!)
            resetSurface()
        }
    }

    fun updateVisualiser(visualiser: Visualiser?) {
        this.visualiser = visualiser
    }

    fun updateDIY(diy: DIY?) {
        this.diy = diy
    }

    fun resetSurface() {
        surface?.eraseColor(Color.TRANSPARENT)
        canvas?.drawColor(Color.WHITE)
    }

    fun display() {
        if (visualiser != null) {
            Handler(Looper.getMainLooper()).post { visualiser!!.setCanvas(surface) }
        } else {
            Handler(Looper.getMainLooper()).post { diy!!.setSurface(surface) }
        }
    }

}


