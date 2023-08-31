package com.example.drawingapp

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatButton

class DrawingView(context: Context, attr: AttributeSet): View(context,attr) {

    var mainPaint:Paint = Paint();
//    var pathList = ArrayList<Path>()


    init {
        mainPaint!!.color = Color.BLACK
        mainPaint!!.style = Paint.Style.STROKE
        mainPaint!!.strokeCap = Paint.Cap.ROUND
        mainPaint.strokeWidth = 10f

    }
    var xPos = 0f
    var yPos = 0f

    override fun onDraw(canvas: Canvas?) {
        if(!list.pathList.isEmpty()){
            for (path in list.pathList){
                canvas!!.drawPath(path, mainPaint)
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event!!.action == MotionEvent.ACTION_DOWN){
            xPos = event!!.x
            yPos = event.y

            val path = Path()
            path.moveTo(xPos, yPos)
            list.pathList.add(path)
            invalidate()
            return true
        }
        else if(event!!.action == MotionEvent.ACTION_MOVE){
            xPos = event!!.x
            yPos = event.y
            list.pathList.get(list.pathList.size - 1).lineTo(xPos, yPos)
            invalidate()
            return true
        }
        else{
            return false;
        }
    }
}