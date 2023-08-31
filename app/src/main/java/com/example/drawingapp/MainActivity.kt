package com.example.drawingapp

import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    var but: AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        but = findViewById(R.id.clearDrawing)

        but!!.setOnClickListener {
            list.pathList.clear()
        }
    }

}