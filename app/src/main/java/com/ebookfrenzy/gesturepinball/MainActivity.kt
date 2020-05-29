package com.ebookfrenzy.gesturepinball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.view.GestureDetectorCompat
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() , GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    var gDetector: GestureDetectorCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtDirections.text = "Single Tap -> Shows an image of the machine\n" +
                "Double Tap -> Shows the release date\n" +
                "Long Press -> Shows the manufacturer\n" +
                "Scroll ->Shows the name of the machine\n" +
                "Fling -> Resets All"

        this.gDetector = GestureDetectorCompat(this, this)
        gDetector?.setOnDoubleTapListener(this)

    }

    override fun onDown(e: MotionEvent?): Boolean {
        return true
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        imageMachine.visibility = View.INVISIBLE
        txtRelease.visibility = View.INVISIBLE
        txtManufacturer.visibility = View.INVISIBLE
        txtNameOfMachine.visibility = View.INVISIBLE
        return true
    }

    override fun onLongPress(e: MotionEvent?) {
        txtManufacturer.visibility = View.VISIBLE
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        txtNameOfMachine.visibility = View.VISIBLE
        return true
    }

    override fun onShowPress(e: MotionEvent?) {

    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
       imageMachine.visibility = View.VISIBLE
        return true
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        txtRelease.visibility = View.VISIBLE
        return true
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        return true
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        return true
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        this.gDetector?.onTouchEvent(event)
        return super.onTouchEvent(event)
    }
}